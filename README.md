# Módulo Web Alimentos Santiago
Implementación de una infraestructura informática web para
la gestión de pedidos via online, que da a conocer a los clientes la variedad de platos disponibles,
permitiendo a los usuarios seleccionar el/los platos a llevar. Dependiendo de la
opción se gestiona la entrega en local indicando hora y fecha o en su defecto entrega a
domicilio, siendo expuesto para los repartidores quienes deben ingresar al módulo web en el cual
ellos seleccionan los pedidos que estimen convenientes.

Los usuarios dispondrán una cuenta en la
plataforma, para ello deberán registrarse, dentro de su cuenta se mostrará el estado monetario,
si es que fuera una cuenta de un trabajador afiliado a un convenio, estos dispondrán de saldo el
bono percibido por la empresa.
Por otra parte, los usuarios podrán ver el estado en que se encuentra el pedido (elaborando,
cocinando o en despacho).

El convenio de los trabajadores lo realiza el empleador en cuestión,
mediante el módulo web accediendo al módulo de empleador es posible subir un archivo el cual contenga el listado de trabajadores
y su información para enviarlo al restaurant donde posteriormente con esta información se crearán sus cuentas de usuario.

Este módulo web trabaja en conjunto con 2 WebServices REST los cuales son:

1.- WebService Domino, retorna los platos disponibles.

2.- WebService Empresa, presenta operaciones para validar la existencia de un trabajador en la empresa y para almacenar la información de las transacciones realizadas por el trabajador en el restaurant.

Además se incluye la implementación de AWS S3 con la finalidad de almacenar los archivos con los listados de trabajadores e imágenes de platos.
