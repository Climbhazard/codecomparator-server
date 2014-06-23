-- phpMyAdmin SQL Dump
-- version 4.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-06-2014 a las 00:44:43
-- Versión del servidor: 5.5.35-0+wheezy1
-- Versión de PHP: 5.4.4-14+deb7u9


--
-- Base de datos: `codecomparator_remote`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE IF NOT EXISTS `alumno` (
  `n_alumno_id` varchar(10) NOT NULL COMMENT 'Id alumno',
  `t_nombre` varchar(50) DEFAULT NULL COMMENT 'Nombre alumno',
  `t_apellido_paterno` varchar(50) DEFAULT NULL COMMENT 'Apellido paterno alumno',
  `t_apellido_materno` varchar(50) DEFAULT NULL COMMENT 'Apellido materno alumno'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comparacion`
--

CREATE TABLE IF NOT EXISTS `comparacion` (
  `n_comparacion_id` int(10) unsigned NOT NULL COMMENT 'Id comparación',
  `t_descripcion` varchar(200) DEFAULT NULL COMMENT 'Descripción de la comparación realizada',
  `n_tipo_comparacion` int(3) unsigned NOT NULL DEFAULT '0' COMMENT 'Tipo de comparación realizada: 0-por defecto 1-adyacente 2-uno a varios',
  `n_evaluacion_id` int(10) unsigned NOT NULL COMMENT 'Id evaluación a la cual pertenece esta comparación',
  `n_alumno_comparado_id` varchar(10) NOT NULL COMMENT 'Id (fk1) alumno contra el que se compara',
  `id_alumno_a_comparar_id` varchar(10) NOT NULL COMMENT 'Id (fk2) alumno a comparar'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE IF NOT EXISTS `curso` (
  `n_curso_id` int(10) unsigned NOT NULL COMMENT 'Id curso',
  `t_nombre` varchar(100) DEFAULT NULL COMMENT 'Nombre curso',
  `n_grupo` int(11) DEFAULT NULL COMMENT 'Número de grupo del curso',
  `n_docente_id` varchar(10) NOT NULL COMMENT 'Id docente (fk)'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docente`
--

CREATE TABLE IF NOT EXISTS `docente` (
  `n_docente_id` varchar(10) NOT NULL COMMENT 'Id del docente',
  `t_nombre` varchar(30) DEFAULT NULL COMMENT 'Nombre(s) del docente',
  `t_apellido_paterno` varchar(30) DEFAULT NULL COMMENT 'Apellido paterno del docente',
  `t_apellido_materno` varchar(30) DEFAULT NULL COMMENT 'Apellido materno del docente'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluacion`
--

CREATE TABLE IF NOT EXISTS `evaluacion` (
  `n_evaluacion_id` int(10) unsigned NOT NULL COMMENT 'Id evaluación',
  `t_descripcion` varchar(50) DEFAULT NULL COMMENT 'Campo en el que se ingresa alguna descripción sobre la evaluación',
  `d_hora_inicio` date NOT NULL COMMENT 'Fecha inicio evaluación',
  `d_hora_fin` date NOT NULL COMMENT 'Fecha fin evaluación',
  `d_fecha_registro` date NOT NULL COMMENT 'Fecha registro evaluación',
  `n_curso_id` int(10) unsigned NOT NULL COMMENT 'Id curso (fk)'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluacion_alumno`
--

CREATE TABLE IF NOT EXISTS `evaluacion_alumno` (
  `n_alumno_id` varchar(10) NOT NULL,
  `n_evaluacion_id` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultado`
--

CREATE TABLE IF NOT EXISTS `resultado` (
  `n_resultado_id` int(10) unsigned NOT NULL COMMENT 'Id resultado',
  `n_comparacion_id` int(10) unsigned NOT NULL COMMENT 'Id comparación a la que pertenece el resultado',
  `n_porcentaje_total` double(7,4) unsigned NOT NULL COMMENT 'Porcentaje total de similitud',
  `t_clases_similares` varchar(500) NOT NULL COMMENT 'JSON que guarda una colección con pares de clases java similares'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_maestra`
--

CREATE TABLE IF NOT EXISTS `tabla_maestra` (
  `n_codigo` int(3) unsigned NOT NULL COMMENT 'Código de la ',
  `t_descripcion` varchar(15) DEFAULT NULL COMMENT 'Descripción del valor almacenado'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `n_usuario_id` int(10) unsigned NOT NULL COMMENT 'Id usuario',
  `t_usuario` varchar(15) DEFAULT NULL COMMENT 'Nombre usuario',
  `t_password` varchar(10) DEFAULT NULL COMMENT 'Password usuario',
  `n_docente_id` varchar(10) NOT NULL COMMENT 'Id docente (fk)'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
 ADD PRIMARY KEY (`n_alumno_id`);

--
-- Indices de la tabla `comparacion`
--
ALTER TABLE `comparacion`
 ADD PRIMARY KEY (`n_comparacion_id`), ADD UNIQUE KEY `FK1` (`n_evaluacion_id`), ADD UNIQUE KEY `FK2` (`n_alumno_comparado_id`), ADD UNIQUE KEY `FK3` (`id_alumno_a_comparar_id`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
 ADD PRIMARY KEY (`n_curso_id`), ADD UNIQUE KEY `FK` (`n_docente_id`);

--
-- Indices de la tabla `docente`
--
ALTER TABLE `docente`
 ADD PRIMARY KEY (`n_docente_id`);

--
-- Indices de la tabla `evaluacion`
--
ALTER TABLE `evaluacion`
 ADD PRIMARY KEY (`n_evaluacion_id`), ADD UNIQUE KEY `FK` (`n_curso_id`);

--
-- Indices de la tabla `evaluacion_alumno`
--
ALTER TABLE `evaluacion_alumno`
 ADD UNIQUE KEY `FK1` (`n_alumno_id`), ADD UNIQUE KEY `FK2` (`n_evaluacion_id`);

--
-- Indices de la tabla `resultado`
--
ALTER TABLE `resultado`
 ADD PRIMARY KEY (`n_resultado_id`), ADD UNIQUE KEY `FK1` (`n_comparacion_id`);

--
-- Indices de la tabla `tabla_maestra`
--
ALTER TABLE `tabla_maestra`
 ADD PRIMARY KEY (`n_codigo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`n_usuario_id`), ADD UNIQUE KEY `FK` (`n_docente_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comparacion`
--
ALTER TABLE `comparacion`
ADD CONSTRAINT `fk_comparacion_alumno_a_comparar` FOREIGN KEY (`id_alumno_a_comparar_id`) REFERENCES `alumno` (`n_alumno_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_comparacion_alumno_comparado` FOREIGN KEY (`n_alumno_comparado_id`) REFERENCES `alumno` (`n_alumno_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_comparacion_evaluacion` FOREIGN KEY (`n_evaluacion_id`) REFERENCES `evaluacion` (`n_evaluacion_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
ADD CONSTRAINT `fk_curso_docente` FOREIGN KEY (`n_docente_id`) REFERENCES `docente` (`n_docente_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `evaluacion`
--
ALTER TABLE `evaluacion`
ADD CONSTRAINT `fk_evaluacion_curso` FOREIGN KEY (`n_curso_id`) REFERENCES `curso` (`n_curso_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `evaluacion_alumno`
--
ALTER TABLE `evaluacion_alumno`
ADD CONSTRAINT `fk_evaluacion_alumno_alumno` FOREIGN KEY (`n_alumno_id`) REFERENCES `alumno` (`n_alumno_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_evaluacion_alumno_evaluacion` FOREIGN KEY (`n_evaluacion_id`) REFERENCES `evaluacion` (`n_evaluacion_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `resultado`
--
ALTER TABLE `resultado`
ADD CONSTRAINT `fk_resultado_comparacion` FOREIGN KEY (`n_comparacion_id`) REFERENCES `comparacion` (`n_comparacion_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
ADD CONSTRAINT `fk_usuario_docente` FOREIGN KEY (`n_docente_id`) REFERENCES `docente` (`n_docente_id`) ON DELETE CASCADE ON UPDATE CASCADE;
