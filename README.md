# Sistema POS Mini

Este es un sistema de punto de venta (POS) básico diseñado en Java, que permite gestionar productos, realizar compras y controlar un crédito disponible para un usuario. El sistema simula la funcionalidad básica de un comercio en el que el usuario puede interactuar con un catálogo de productos, agregar nuevos productos, realizar compras y ver el total de sus compras, todo dentro de un ciclo de interacción.

## Funcionalidades

1. **Ver lista de productos:** Muestra la lista de productos disponibles, ordenada alfabéticamente por nombre.
2. **Agregar un producto:** Permite al usuario agregar nuevos productos al inventario con un nombre y precio.
3. **Comprar un producto:** El usuario puede comprar productos del inventario, siempre y cuando tenga crédito suficiente. Se muestra un recibo con la compra realizada y el crédito restante.
4. **Ver crédito disponible:** Muestra el crédito restante que el usuario tiene disponible para realizar compras.
5. **Ver total de compras:** Muestra el total acumulado de las compras realizadas hasta el momento.
6. **Salir:** Finaliza el programa.

## Detalles del código

- **Productos:** Se crean productos con nombre y precio, y se almacenan en un `ArrayList`.
- **Crédito:** El usuario tiene un crédito disponible al inicio, y cada compra reduce dicho crédito. Si no hay suficiente crédito para realizar una compra, el sistema informa al usuario.
- **Interacción:** El usuario puede interactuar con el sistema mediante un menú con opciones que le permiten ver los productos, agregar productos, realizar compras y consultar su crédito.

## ¿Cómo ejecutar el programa?

1. Clona el repositorio o descarga los archivos.
2. Compila y ejecuta el archivo `Principal.java` en tu entorno de desarrollo Java (por ejemplo, IntelliJ IDEA, Eclipse, etc.).
3. Interactúa con el sistema a través de la consola ingresando las opciones que te ofrece el menú.
