Create table pedidos (
	codigo VARCHAR(20) NOT NULL,
	tipo VARCHAR(40),
	nombre VARCHAR(40),
    cantidad INT,
	precio_total FLOAT,
	fecha_pedido DATE,
	FOREIGN KEY (codigo) REFERENCES tienda (codigo)
);

INSERT INTO CLIENTE VALUES 
('38111238P', 'Laura', 'Gomez', 'Perez', '639875421', '944568978', 'Karmelo, 24', 'Bilbao'),
INSERT INTO CLIENTE VALUES ('67228357R', 'Jon', 'Medel', 'Alvarez','698523698', '687495925', 'Bidasoa Ibaia, 7', 'Basauri');
INSERT INTO CLIENTE (dni, nombre, apellido1, apellido2, direccion, localidad, telefono1) VALUES ('53881762F', 'Nerea', 'Herrera', 'Rueda', 'Gran Via, 85', 'Bilbao', '685497564');

INSERT INTO CLIENTE (dni, nombre, apellido1, apellido2, direccion, localidad, telefono1) VALUES ('59925653G', 'Juan', 'Palomo', 'Rodriguez', 'Brazomar, 54', 'Castro Urdiales', '685296471');


INSERT INTO mascota VALUES
('38111238P','Laika', 'Perro','Border Collie', 'hembra','2015-05-01', true),
('67228357R','Misi','Gato', 'Común', 'hembra','2014-08-10', true),
('53881762F','Calcetines', 'Gato', 'Persa','macho', '2017-04-20', false);
('67228357R', 'Kiko', 'Gato', 'Común', 'macho', '2013-02-17', true);

INSERT INTO personal VALUES 
('10280927L', 'Sonia','Perez', 'Lopez', 'veterinario', 'Medicina felina'),
('29505349Y', 'Alberto', 'Romero', 'Ruiz', 'veterinario', 'Medicina canina'),
('19938298N', 'Pablo', 'Ramirez', 'Goikoetxea', 'veterinario', 'Cirugía general');

INSERT INTO personal (id, nombre, apellido1, apellido2, cargo) VALUES
('21355523T', 'Ana', 'Gomez', 'Suñer', 'Auxiliar'),
('12997449B', 'Belén', 'Blanco', 'Almirez', 'Auxiliar');

INSERT INTO tienda VALUES 
('CTZ2217', 'Catzilla Sterilised', 'Pienso para gatos adultos esterilizados', 'gato', 'pienso', 14.50, )


INSERT INTO usuarios VALUES
('38111238P', 'LAU381', 3),
('67228357R', 'JON672', 3),
('53881762F', 'NER538', 3),
('10280927L','SON102', 2),
('21355523T', 'ANA213', 2),
('59925653G', 'JUA599', 3);
('26768555M','ALB267', 3);

INSERT INTO mascota (id, nombre, tipo, raza, sexo, fechaNacimiento, castrado) VALUES ('59925653G', 'Linda', 'perro', 'Pastor aleman','2014-05-09', 'hembra', true);

245,255,250

 try {
			 Cliente cliente = manager.getCliente(dniUsuario);
			 textNombreUser.setText(cliente.getNombre());
			 textApellUser1.setText(cliente.getApellido1());
			 textApellUser2.setText(cliente.getApellido2());
			 textDireccUser.setText(cliente.getDireccion());
			 textLocalidad.setText(cliente.getLocalidad());
			 textTelefUser.setText(cliente.getTelefono1());
			 textTelefUser2.setText(cliente.getTelefono2());
			 
		 }
		 catch(Exception e1) {
			 e1.getMessage();
		 }
		 