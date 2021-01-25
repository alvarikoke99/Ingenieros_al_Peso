# Empresas 
INSERT INTO `web`.`empresa`(`nombre`,`descripcion`)VALUES('MariaDB','Base datos.');
INSERT INTO `web`.`empresa`(`nombre`,`descripcion`)VALUES('Pokemon company','Compania japonesa creada para controlar.');
INSERT INTO `web`.`empresa`(`nombre`,`descripcion`)VALUES('Riot Games','es una desarrollador de videojuegos estadounidense  y organizada de torneos eSports.');
# Trabajadores
INSERT INTO `web`.`trabajador`(`nombre`,`apellidos`,`dni`)VALUES('Alvaro','Barchin','0987654A');
INSERT INTO `web`.`trabajador`(`nombre`,`apellidos`,`dni`)VALUES('María','Bravo','0123456G');
INSERT INTO `web`.`trabajador`(`nombre`,`apellidos`,`dni`)VALUES('Daniela','Durand','098765D');
# Proyectos
INSERT INTO `web`.`proyecto`(`nombre`,`informacion`,`id_empresa`)VALUES('Lol','Nuevo MOBA',3);
INSERT INTO `web`.`proyecto`(`nombre`,`informacion`,`id_empresa`)VALUES('CorteIngles','Base de datos de la empresa CorteIngles',1);
INSERT INTO `web`.`proyecto`(`nombre`,`informacion`,`id_empresa`)VALUES('Pokemon Escudo en llamas','Nueva version de pokemon scudo',2);
# Solicitud
INSERT INTO `web`.`solicitud`(`tipo`,`fecha_ini`,`fecha_final`,`tramitada`,`id_trabajador`)VALUES('Dias libres','2020-01-23','2020-02-01',null,1);
INSERT INTO `web`.`solicitud`(`tipo`,`fecha_ini`,`fecha_final`,`tramitada`,`id_trabajador`)VALUES('Vaciones','2020-03-01','2020-04-01',null,2);
INSERT INTO `web`.`solicitud`(`tipo`,`fecha_ini`,`fecha_final`,`tramitada`,`id_trabajador`)VALUES('Medico-ginecologo','2020-01-2','2020-01-3',null,3);
# relacion_proyecto_trabajador
INSERT INTO `web`.`relacion_proyecto_trabajador`(`id_proyecto`,`id_trabajador`)VALUES(3,2);s
INSERT INTO `web`.`relacion_proyecto_trabajador`(`id_proyecto`,`id_trabajador`)VALUES(2,1);
INSERT INTO `web`.`relacion_proyecto_trabajador`(`id_proyecto`,`id_trabajador`)VALUES(1,3);
# relacion_empresa_trabajador
INSERT INTO `web`.`relacion_empresa_trabajador`(`id_trabajador`,`id_empresa`,`departamento`)VALUES(2,1,'Programador');
INSERT INTO `web`.`relacion_empresa_trabajador`(`id_trabajador`,`id_empresa`,`departamento`)VALUES(1,2,'Programador');
INSERT INTO `web`.`relacion_empresa_trabajador`(`id_trabajador`,`id_empresa`,`departamento`)VALUES(3,3,'Programador');
# registro_jornada 
INSERT INTO `web`.`registro_jornada`(`fecha_entrada`,`fecha_salida`,`id_trabajador`,`id_proyecto`)VALUES('2020-01-15 10:10:02','2020-01-15 12:10:05',1,2);
INSERT INTO `web`.`registro_jornada`(`fecha_entrada`,`fecha_salida`,`id_trabajador`,`id_proyecto`)VALUES('2020-01-16 10:10:02','2020-01-15 16:10:05',2,1);
INSERT INTO `web`.`registro_jornada`(`fecha_entrada`,`fecha_salida`,`id_trabajador`,`id_proyecto`)VALUES('2020-01-17 10:10:02','2020-01-15 17:10:05',3,3);
# horas_jornada
INSERT INTO `web`.`horas_jornada`(`horas`,`fecha`,`id_proyecto`,`id_trabajador`)VALUES(16,'2020-01-14',1,2);
INSERT INTO `web`.`horas_jornada`(`horas`,`fecha`,`id_proyecto`,`id_trabajador`)VALUES(20,'2020-01-15',2,3);
INSERT INTO `web`.`horas_jornada`(`horas`,`fecha`,`id_proyecto`,`id_trabajador`)VALUES(10,'2020-01-16',3,1);



