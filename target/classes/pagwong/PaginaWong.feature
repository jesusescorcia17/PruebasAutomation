@tag
Feature: Prueba tecnica para ingeniero de automatizacion en giros y finanzas
		 Realizar la automatizacion de un producto de compra

	@tagPruebaGirosYfinanza
	Scenario Outline: proceso de compra de un producto
	
	Given abrir la pagina Prueba wong
	And validar politicas generales y aceptar terminos
	And seleccionas el producto
	And si pide correo se agrega "<correo>"
	And si pide click en recojo en tienda
	And selecciona tienda
	And seleccionas direccion"<Dirccion>"
	And click recojo aqui"<numero>"
	And aceptar si click 
	Then Verificar el producto
	And Cerramos la pagina

	Examples: 
	|correo 						|Dirccion      							     |numero|
	|jesusescorcia@girosyfinanza.com|Miraflores kenedy, Diagonal, Miraflores, Per|32|
