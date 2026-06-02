# TechChallengeSofka - QA Automation

Prueba técnica de Sofka para QA Automation usando Serenity BDD y JUnit 5.

## 📋 Descripción del Proyecto

Este proyecto implementa un marco de trabajo de automatización de pruebas utilizando:
- **Serenity BDD v5.3.7**: Framework para automatización de pruebas con reportes avanzados
- **JUnit 5**: Framework de testing moderno
- **Maven**: Gestor de dependencias y build
- **Java 17**: Lenguaje de programación

## 🚀 Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes requisitos:

- **Java Development Kit (JDK) 17+**: [Descargar JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- **Maven 3.6.0+**: [Descargar Maven](https://maven.apache.org/download.cgi)
- **Git**: [Descargar Git](https://git-scm.com/)

### Verificar las Instalaciones

```bash
# Verificar Java
java -version

# Verificar Maven
mvn -version

# Verificar Git
git --version
```

## 📦 Instalación

### 1. Clonar el Repositorio

```bash
git clone https://github.com/ivansanchez93/TechChallengeSofka.git
cd TechChallengeSofka
```

### 2. Descargar Dependencias

```bash
mvn clean install
```

Este comando descargará todas las dependencias necesarias del proyecto.

## ▶️ Ejecutar las Pruebas

### Ejecutar Todas las Pruebas

```bash
mvn clean test
```

### Ejecutar Pruebas Específicas

```bash
# Ejecutar una clase de prueba específica
mvn test -Dtest=NombreDelTest

# Ejecutar una prueba específica
mvn test -Dtest=NombreDelTest#nombreDelMetodo
```

### Ejecutar con Serenity BDD

```bash
mvn clean verify
```

Este comando ejecutará todas las pruebas y generará los reportes de Serenity BDD.

## 📊 Ver Reportes

Después de ejecutar las pruebas con Serenity, puedes ver los reportes:

```bash
# Los reportes se generan en:
target/site/serenity/index.html
```

Abre el archivo `target/site/serenity/index.html` en tu navegador para ver los reportes detallados.

## 📁 Estructura del Proyecto

```
TechChallengeSofka/
├── src/
│   ├── main/           # Código principal (si aplica)
│   └── test/           # Clases de prueba y Step Definitions
├── target/             # Carpeta generada con compilación y reportes
├── .idea/              # Configuración de IntelliJ IDEA (IDE)
├── pom.xml            # Configuración de Maven y dependencias
├── .gitignore         # Archivos ignorados por Git
└── README.md          # Este archivo
```

## 🛠️ Dependencias Principales

| Dependencia | Versión | Propósito |
|---|---|---|
| Serenity Core | 5.3.7 | Framework de automatización y reportes |
| Serenity JUnit5 | 5.3.7 | Integración con JUnit 5 |
| JUnit Jupiter | 6.0.3 | Framework de testing |
| JUnit Platform Suite | - | Suite de pruebas JUnit |

## 🔧 Configuración Adicional

### Variables de Entorno (Opcional)

Si necesitas establecer propiedades especiales para las pruebas:

```bash
# En Linux/Mac:
export MAVEN_OPTS="-Xmx1024m"

# En Windows (CMD):
set MAVEN_OPTS=-Xmx1024m

# En Windows (PowerShell):
$env:MAVEN_OPTS = "-Xmx1024m"
```

## 💡 Recomendaciones

- **IDE Recomendado**: IntelliJ IDEA Community Edition (incluye soporte nativo para Maven)
- **Build Tool**: Maven (recomendado para este proyecto)
- **JVM Memory**: Asigna al menos 1GB de RAM para la máquina virtual Java

## 🐛 Solución de Problemas

### Error: "Java no está instalado"
```bash
# Instala JDK 17
# Linux (Ubuntu/Debian):
sudo apt-get install openjdk-17-jdk

# macOS (con Homebrew):
brew install openjdk@17

# Windows:
# Descarga el instalador desde oracle.com
```

### Error: "Maven no está instalado"
```bash
# Linux/macOS:
brew install maven

# Windows:
# Descarga desde maven.apache.org
# Añade la carpeta bin de Maven a las variables de entorno
```

### Error: "Dependencias no se descargan"
```bash
# Limpia el caché de Maven
mvn clean

# Descarga nuevamente las dependencias
mvn dependency:resolve
```

### Error: "Puerto en uso" o problemas de compilación
```bash
# Limpia completamente la compilación anterior
mvn clean install -DskipTests

# Luego ejecuta las pruebas
mvn test
```

## 📚 Recursos Útiles

- [Documentación de Serenity BDD](https://serenity-bdd.info/)
- [Documentación de JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
- [Documentación de Maven](https://maven.apache.org/guides/index.html)
- [Documentación de Java 17](https://docs.oracle.com/en/java/javase/17/)

## 👤 Autor

**Ivan Sanchez**
- GitHub: [@ivansanchez93](https://github.com/ivansanchez93)

## 📝 Notas Importantes

- El proyecto utiliza Java 17 como versión objetivo de compilación
- La codificación del proyecto es UTF-8
- Los reportes se generan automáticamente en `target/site/serenity/`
- Las pruebas se ejecutan en el scope de test, no afectarán el código principal

## 📄 Licencia

Este proyecto es una prueba técnica de Sofka.

---

¿Necesitas ayuda adicional? Abre un issue en el repositorio con tus dudas.
