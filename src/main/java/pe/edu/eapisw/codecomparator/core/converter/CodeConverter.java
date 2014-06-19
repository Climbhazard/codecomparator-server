package pe.edu.eapisw.codecomparator.core.converter;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Clase que implementa los métodos de conversión del código fuente.
 * 
 */
public class CodeConverter {
	// public String file;
	private BufferedReader file;
	private ArrayList<String> codeLines = new ArrayList<String>();
	public ArrayList<CodeImage> convertedCode = new ArrayList<CodeImage>();
	public boolean IsCategoryLevel;

	public Double[] Q;
	public StartUp config;

	public String[] split(String value, String[] separators) {
		String[] words = null;
		ArrayList<String> temp = new ArrayList<>();
		for (String separator : separators) {
			value = value.replaceAll(separator, "¬");
		}
		words = value.split("¬");
		for (String word : words) {
			if (!word.isEmpty())
				temp.add(word);
		}
		words = new String[temp.size()];
		temp.toArray(words);
		return words;
	}

	private String insert(String source, int index, String pattern) {
		String out = source.substring(0, index) + pattern
				+ source.substring(index);
		return out;
	}

	/**
	 * Remueve los comentarios del archivo fuente y divide el código en
	 * instrucciones, que se almacenarán en un ArrayList
	 */
	private void RemoveComments() {
		String line = "--";
		try {
			BufferedReader br = file;
			while ((line = br.readLine()) != null) {
				int index;
				// Es comentario simple
				if (line.contains("//")) {
					index = line.indexOf("//");
					line = line.substring(0, index);
				}
				// Es comentario multiple
				else if (line.contains("/*")) {
					index = line.indexOf("/*");
					while (!line.contains("*/")) {
						index = -1;
						line = br.readLine();
						// line = sr.ReadLine();
					}
					int index2 = line.indexOf("*/");
					if (index2 >= 0 && index != -1) {
						line = line.substring(0, index)
								+ line.substring(index + (index2 + 2));
					} else {
						line = line.substring(0, 0)
								+ line.substring(0 + (index2 + 2));
					}
				}
				// Dividir las lineas de codigo en instrucciones
				String[] se = new String[] { "\t", "\n", "\r", ";" };
				String[] tokens = split(line, se);
				for (String token : tokens) {
					if (!token.equals("")) {
						codeLines.add(token);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * De las instrucciones almacenadas en <code>codeLines</code>, se remueven
	 * las directivas <code>import</code> para códigos Java.
	 */
	@SuppressWarnings("unchecked")
	private void RemoveDirectives() {
		ArrayList<String> temp = new ArrayList<String>();
		String t;
		for (int index = 0; index < codeLines.size(); index++) {
			t = (String) codeLines.get(index);
			if (t.contains("import")) {
				continue;
			} else {
				temp.add(codeLines.get(index));
			}
		}
		codeLines.clear();
		codeLines = (ArrayList<String>) temp.clone();
		temp.clear();
	}

	/**
	 * Métodos principales, convierten las instrucciones en valores numéricos,
	 * dependiendo del metodo que se utilize TransformCodeOperatorLevel o
	 * TransformCodeCategoryLevel [codificación en detalle].
	 */
	@SuppressWarnings("static-access")
	public final void TransformCodeOperatorLevel() {
		try {
			RemoveComments();
			RemoveDirectives();
			IsCategoryLevel = false;

			/*
			 * En el arreglo split deben encontrarse todos los operadores del
			 * lenguaje además de los separadores de clase y de función
			 */
			String[] se = new String[] { "[{]+", "}", " " };
			String[] split = new String[config.operators.length + se.length];
			// config.operators.CopyTo(split, 0);
			System.arraycopy(config.operators, 0, split, 0,
					config.operators.length);
			System.arraycopy(se, 0, split, config.operators.length, se.length);

			String line;
			for (int index = 0; index < codeLines.size(); index++) {
				line = (String) codeLines.get(index);
				// String[] tokens = line.Split(split,
				// StringSplitOptions.RemoveEmptyEntries);
				String[] tokens = split(line, split);
				String operaciones = line;

				/*
				 * Diferencia del vector de tokens con la línea de código para
				 * obtener las operaciones que afectan a esa línea
				 */
				for (int i = 0; i < tokens.length; i++) {
					if (operaciones.contains(tokens[i])) {
						int ind = operaciones.indexOf(tokens[i]);
						operaciones = operaciones.substring(0, ind)
								+ operaciones.substring(ind
										+ tokens[i].length());
						// operaciones = operaciones.insert(ind, "¿");
						operaciones = insert(operaciones, ind, "¿");
					}
				}

				ArrayList<Double> token_line = new ArrayList<Double>();
				int pos = 0;
				for (int j = 0; j < operaciones.length(); j++) {
					// if (operaciones.charAt(j).equals('¿')) {
					if (operaciones.charAt(j) == '¿') {
						token_line.add(TokenValue(tokens[pos++]));
					}
					// else if (operaciones.charAt(j).toString().equals(" ") ==
					// false
					// && operaciones.charAt(j).toString().equals("{") == false
					// && operaciones.charAt(j).toString().equals("}") == false)
					// {
					else if (operaciones.charAt(j) == ' '
							&& operaciones.charAt(j) == '{'
							&& operaciones.charAt(j) == '}') {
						int next_quote = operaciones.indexOf("¿", j);
						String op;
						if (next_quote > j) {
							op = operaciones.substring(j, next_quote);
						} else {
							op = operaciones.substring(j, operaciones.length());
						}
						token_line.add(TokenValue(op));
						if (next_quote != -1) {
							j = next_quote - 1;
						} else {
							break;
						}
					}
				}

				if (token_line.size() > 1) {
					CodeImage ci = new CodeImage(token_line, line);
					// ci.code_line = line;
					// ci.code_img = token_line;
					convertedCode.add(ci);
				}
			}
			ArrayList<Double> temp = new ArrayList<Double>();
			// if (((Code_Image) converted_code.get(0)).code_img[0].getClass()
			// .getName().equals("Double")) {
			if (convertedCode.get(0).getCode_img().get(0) instanceof Double) {
				for (CodeImage TkLn : convertedCode) {
					for (double val : TkLn.getCode_img()) {
						temp.add(val);
					}
				}
				// this.Q = (double[]) temp.toArray(new double[0]);
				this.Q = new Double[temp.size()];
				temp.toArray(this.Q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public final void TransformCodeCategoryLevel() {
	// RemoveComments();
	// RemoveDirectives();
	// IsCategoryLevel = true;
	//
	// String[] se = new String[] { "{", "}", " " };
	// String[] split = new String[config.operators.getLength() + se.length];
	// config.operators.CopyTo(split, 0);
	// System.arraycopy(se, 0, split, config.operators.getLength(), se.length);
	// String line;
	// int openPh = 0;
	// for (int index = 0; index < code_lines.size(); index++) {
	// line = (String) code_lines.get(index);
	// String[] tokens = line.split(split,
	// StringSplitOptions.RemoveEmptyEntries);
	// String operaciones = line;
	// for (int i = 0; i < tokens.length; i++) {
	// if (operaciones.contains(tokens[i])) {
	// int ind = operaciones.indexOf(tokens[i]);
	// operaciones = operaciones.substring(0, ind)
	// + operaciones.substring(ind + tokens[i].length());
	// operaciones = operaciones.insert(ind, "¿");
	// }
	// }
	// java.util.ArrayList token_line = new java.util.ArrayList();
	// operaciones = operaciones.trim();
	// String[] ops = operaciones.split(new char[] { '¿', ' ' },
	// StringSplitOptions.RemoveEmptyEntries);
	// for (String s1 : ops) {
	// String s = s1.trim();
	// if (s.contains("(")) {
	// openPh++;
	// token_line.add(CatValue("("));
	// int ind = s.indexOf("(");
	// String s2;
	// if (ind >= 0) {
	// s2 = s.substring(0, ind) + s.substring(ind + 1);
	// if (!s2.equals("")) {
	// token_line.add(CatValue(s2));
	// }
	// }
	// } else if (s.equals(")")) {
	// openPh--;
	// } else if (s.equals("))")) {
	// openPh--;
	// } else if (s.contains(")")) {
	// token_line.add(CatValue(")"));
	// int ind = s.indexOf(")");
	// String s2;
	// if (ind >= 0) {
	// s2 = s.substring(0, ind) + s.substring(ind + 1);
	// if (!s2.equals("") && !s2.equals(")")) {
	// token_line.add(CatValue(s2));
	// }
	// }
	// } else if (s.equals("{") == false && s.equals("}") == false
	// && s.equals("") == false) {
	// double v = CatValue(s);
	// if (v != Double.MAX_VALUE) {
	// token_line.add(CatValue(s));
	// } else {
	// System.out.println("Error: TOKEN{0} LINE{1}", s, line);
	// }
	// }
	// }
	//
	// if (token_line.size() > 0) {
	// Code_Image ci = new Code_Image();
	// ci.code_line = line;
	// ci.code_img = token_line;
	// converted_code.add(ci);
	// }
	// }
	// java.util.ArrayList temp = new java.util.ArrayList();
	// if (((Code_Image) converted_code.get(0)).code_img[0].getClass()
	// .getName().equals("Double")) {
	// for (Code_Image TkLn : converted_code) {
	// for (double val : TkLn.code_img) {
	// temp.add(val);
	// }
	// }
	// this.Q = (double[]) temp.toArray(new double[0]);
	// }
	// temp.clear();
	// }
	//
	/*
	 * FunciÃ³n que retorna el valor del token, es invocada desde
	 * TransformCodeOperatorLevel
	 */
	@SuppressWarnings({ "unused", "static-access" })
	private double TokenValue(String _token) {
		// Arreglo de palabras reservadas
		ArrayList<Item> reserved = config.reserved;
		// Arreglo de clases de operadores
		ArrayList<TokenCategory> categories = config.categories;
		boolean found = false;
		String token = _token.trim();
		double value = Double.MAX_VALUE;
		// Buscar en las palabras reservadas
		for (Item word : reserved) {
			if (token.compareTo(word.getId()) == 0) {
				found = true;
				value = word.getValue();
				break;
			}
		}
		if (found) {
			return value;
		} else {
			// Buscar en los operadores
			for (TokenCategory cat : categories) {
				for (int i = 0; i < cat.getObjects().length; i++) {
					Item j = ((Item) cat.getObjects()[i]);
					if (token.compareTo(j.getId()) == 0) {
						found = true;
						value = j.getValue();
						break;
					}
				}
			}
			if (found) {
				return value;
			} else {
				// Realizar un cast, para determinar si es una constante
				try {
					double L = Double.parseDouble(token);
					found = true;
				} catch (RuntimeException e) {
					found = false;
				}
				if (found) // i.e value = 0.7
				{
					return value = config.constant_value;
				} else {
					// En caso contrario es una variable i.e value = 0.9
					return value = config.variable_value;
				}
			}
		}
	}

	//
	// /*
	// * FunciÃ³n que retorna el valor de la categoria de un operador, es
	// invocada
	// * desde TransformCodeCategoryLevel
	// */
	// private double CatValue(String _token) {
	// // Arreglo de clases de operadores
	// java.util.ArrayList categories = config.categories;
	// String token = _token.trim();
	// double value = Double.MAX_VALUE();
	// // Buscar en los operadores
	// for (TokenCategory cat : categories) {
	// for (int i = 0; i < cat.objects.size(); i++) {
	// Item j = ((Item) cat.objects[i]);
	// if (token.compareTo(j.id) == 0) {
	// value = cat.value;
	// break;
	// }
	// }
	// }
	// return value;
	// }
	//
	// /*
	// * Una vez que se ha identificado un token, se busca en la lista de
	// palabras
	// * reservadas, en el arreglo de operadores, de no encontrarse, se
	// identifica
	// * como constante numÃ©rica o variable. Este mÃ©todo sÃ³lo se utiliza para
	// * escribir a un archivo el tipo de operador que le corresponde. Es
	// invocado
	// * por WriteFileTransform().
	// */
	// private String TokenType(double value) {
	// // Arreglo de palabras reservadas
	// java.util.ArrayList reserved = config.reserved;
	// // Arreglo de clases de operadores
	// java.util.ArrayList categories = config.categories;
	// boolean found = false;
	// for (Item word : reserved) {
	// if (word.value = value) {
	// found = true;
	// break;
	// }
	// }
	// if (found) {
	// return "RESERVED";
	// } else {
	// // Buscar en los operadores
	// for (TokenCategory cat : categories) {
	// for (int i = 0; i < cat.objects.size(); i++) {
	// Item j = ((Item) cat.objects[i]);
	// if (j.value = value) {
	// found = true;
	// break;
	// }
	// }
	// }
	// if (found) {
	// return "OPERATOR";
	// } else {
	// if (value == config.constant_value) {
	// return "CONSTANT";
	// } else if (value == config.variable_value) {
	// // En caso contrario es una variable
	// return "VARIABLE";
	// } else {
	// return null;
	// }
	// }
	// }
	// }

	public ArrayList<String> getCodeLines() {
		return codeLines;
	}

	public void setFile(BufferedReader file) {
		this.file = file;
	}
}
