# Empresas 
INSERT INTO `web`.`empresa`(`nombre`,`descripcion`)VALUES('MariaDB','Somos unas foquitas');
INSERT INTO `web`.`empresa`(`nombre`,`descripcion`)VALUES('Paco S.A.','No somos unas foquitas');
INSERT INTO `web`.`empresa`(`nombre`,`descripcion`)VALUES('Delfin S.A.','Nos gustan las caballas');
# Trabajadores
INSERT INTO `web`.`trabajador`(`nombre`,`apellidos`,`dni`)VALUES('Alvaro','Barchin','0987654A');
INSERT INTO `web`.`trabajador`(`nombre`,`apellidos`,`dni`)VALUES('María','Bravo','0123456G');
INSERT INTO `web`.`trabajador`(`nombre`,`apellidos`,`dni`)VALUES('Daniela','Durand','098765D');
# Proyectos
INSERT INTO `web`.`proyecto`(`nombre`,`informacion`,`id_empresa`)VALUES('Manhattan','trabajamos en la bomba nuclear shhh!!',3);
INSERT INTO `web`.`proyecto`(`nombre`,`informacion`,`id_empresa`)VALUES('Cosechando-esperanza','Trabajamos por un mundo con graficas mejores',2);
INSERT INTO `web`.`proyecto`(`nombre`,`informacion`,`id_empresa`)VALUES('Manitas-en-accion','Programa para mejorar las manitas chiquitas',1);
# Solicitud
INSERT INTO `web`.`solicitud`(`tipo`,`fecha_ini`,`fecha_final`,`observacion`,`tramitada`,`id_trabajador`)VALUES('Dias libres','2020-01-23','2020-02-01','Me voy a montar mi PC master raze',false,1);
INSERT INTO `web`.`solicitud`(`tipo`,`fecha_ini`,`fecha_final`,`observacion`,`tramitada`,`id_trabajador`)VALUES('Vaciones','2020-03-01','2020-04-01','Me voy a Andorra perras!!',false,2);
INSERT INTO `web`.`solicitud`(`tipo`,`fecha_ini`,`fecha_final`,`observacion`,`tramitada`,`id_trabajador`)VALUES('Medico-ginecologo','2020-01-2','2020-01-3','Me voy a ver si estoy embarazada',false,3);
# relacion_proyecto_trabajador
INSERT INTO `web`.`relacion_proyecto_trabajador`(`id_proyecto`,`id_trabajador`)VALUES(3,2);
INSERT INTO `web`.`relacion_proyecto_trabajador`(`id_proyecto`,`id_trabajador`)VALUES(2,1);
INSERT INTO `web`.`relacion_proyecto_trabajador`(`id_proyecto`,`id_trabajador`)VALUES(1,3);
# relacion_empresa_trabajador
INSERT INTO `web`.`relacion_empresa_trabajador`(`id_trabajador`,`id_empresa`,`departamento`)VALUES(2,1,'RRHH');
INSERT INTO `web`.`relacion_empresa_trabajador`(`id_trabajador`,`id_empresa`,`departamento`)VALUES(1,2,'Tecnologia');
INSERT INTO `web`.`relacion_empresa_trabajador`(`id_trabajador`,`id_empresa`,`departamento`)VALUES(3,3,'I+D');
# registro_jornada 
INSERT INTO `web`.`registro_jornada`
(`fecha_entrada`,`fecha_salida`,`id_trabajador`,`id_proyecto`)VALUES();


