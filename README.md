# ParcialArep2

se realizo la siguiente arquitectura

![image](https://github.com/santiagoOsp01/ParcialArep2/assets/111186366/d58e837b-bd65-4d31-bd03-f7b8502f9fa6)

tenemos un paquete de mathServices que se encarga de la logica y el proxy que funciona como round robir

# Ejecutando

Para ejecutar este proyecto se necesitan mínimo estas tecnologías.

* Maven
* Java
* Git

Para traer el proyecto se usa el siguiente comando:

```
git clone https://github.com/santiagoOsp01/ParcialArep2.git
```
Luego ejecutamos este comando para que traiga nuestras dependencias:

```
mvn package
```
Para ejecutar el proxy se usa el siguiente comando:

```
java -cp "target/classes;target/dependency/*" edu.eci.co.proxy.ServicesProxy
```

Para ejecutar el mathService se usa el siguiente comando:

```
java -cp "target/classes:target/dependency/*" edu.eci.co.logic.MathServices

#Desplegado

lo probamos localmente y vemos que funciona y como cambia de server pero no nos afecta ya que repetimos el localhost
![image](https://github.com/santiagoOsp01/ParcialArep2/assets/111186366/65393a39-a38e-460f-a60b-fedf606fd49a)

![image](https://github.com/santiagoOsp01/ParcialArep2/assets/111186366/1abbb0c9-83a1-4ddc-80be-92cad8693a48)

![image](https://github.com/santiagoOsp01/ParcialArep2/assets/111186366/8bf68176-d4ec-412d-bcf4-56572fed871a)

# desplegando aws

![image](https://github.com/santiagoOsp01/ParcialArep2/assets/111186366/5b5a2f1b-8d13-4c23-bc0b-3be1506a863d)


