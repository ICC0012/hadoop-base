# Partiendo un proyecto Hadoop MapReduce

Requisitos: Java 1.6+, Maven 3

2 opciones: partir desde cero con Maven, o partir de una base.

## Partir de cero con Maven

En el directorio donde quieras poner tu proyecto (e.g. si quiero que mi proyecto `analyzer` quede en `~/workspace/analyzer`, tengo que `cd ~/workspace`), ejecuta `mvn archetype:generate`, elige el que viene por default (`org.apache.maven.archetypes:maven-archetype-quickstart`), la última versión que te ofrezca. Ponle el groupId y artifactId que más te gusten (e.g.: `cl.uandes.icc0012`, y `proyecto-hadoop`), y una versión cualquiera. Listo.

Ahora, tienes que agregar el repositorio de Maven de Cloudera para bajar las librerías necesarias. Edita el archivo `pom.xml`, y en cualquier parte dentro del tag `<project>`, agrega las siguientes líneas:

```xml
<repositories>
    <repository>
        <id>cloudera-releases</id>
        <url>https://repository.cloudera.com/artifactory/cloudera-repos</url>
        <releases>
            <enabled>true</enabled>
        </releases>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>
</repositories>
```

Ahora estás listo para declarar las dependencias. Por ahora, sólo vamos a necesitar `org.apache.hadoop:hadoop-client`. Agrega estas líneas dentro del tag `<dependencies>`.

```xml
<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-client</artifactId>
    <version>2.5.0-cdh5.2.0</version>
</dependency>
```

Todo listo. Ahora puedes escribir tu código tranquilo. Si usas Eclipse, IntelliJ IDEA, NetBeans, o cualquier IDE respetable, va a detectar automáticamente las dependencias y vas a poder importar las clases que necesites. (Es posible que tengas que instalar un plugin de Maven para tu IDE. Normalmente viene instalado.)

Cuando tengas tu programa listo, ejecuta `mvn clean package`, y se va a generar un JAR con tu programa dentro de `target`. Ese JAR es el que le pasas al comando `hadoop jar`.

## Partir desde un proyecto base

Clona (o haz un fork) de este repo y trabaja a partir de él. Puedes cambiar el `artifactId` en el archivo `pom.xml`.