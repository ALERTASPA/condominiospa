package mx.org.dao.libs;
/**
 * @company INEGI
 * @project IKTAN (Sistema de Seguimiento y Control de proyectos estad�sticos)
 * @date 17/01/2018
 * @time 11:52:39 AM
 * @author Jorge Alberto Vazquez Serafin <jorge.vazquezser@inegi.gob.mx>
 */

public final class Constantes {
	public static final String TIPO_ENVIO = "1";
	public static final String TIPO_DESCARGA = "2";
	public static int ENVIO_DISPONIBLE = 1;
	public static int ENVIO_REGENERAR = 2;
	public static int ENVIO_GENERADO = 3;
	public static int ENVIO_TRANSFERIDO = 4;
	public static int ENVIO_REENVIAR = 5;
	public static int ENVIO_DEPOSITADO = 6;
	public static int ENVIO_VERIFICADO = 7;
	public static int ENVIO_INTEGRADO = 8;
	public static int ENVIO_CONFRONTA_LOCAL = 9;
	public static int ENVIO_CONFRONTA_WEB = 10;


	/*constantes para la actualizacion de plantillas*/
	public static final int DATOS_USUARIO = 0;
	public static final int PLANTILLA = 1;

	// constante para sentencias generales
	public static String ID_GENERAL= "X1000";

	public static final int Constantes75 = 0;
	public static final int Constantes50 = 1;
	public static final int Constantes25 = 2;
	public static final int Constantes0 = 3;
	public static final String LEVANTAMIENTO = "1";
	public static final String TABLEROS = "0";
	public static final String UTILERIAS = "2";
	public static final String ACERCADE = "3";

	public static final String VERSION_NUUK = "0.1.6";
	public static final String CONTROL = "oX561r#Yn2%4wp$v";

	public static final Long ID_MOVIL_CONFIGURACION = 1L;

	public static final String COORDINACION_ESTATAL = "CE";
	public static final String ENVIOS = "EW";
	public static final String RESPALDO = "RP";
	public static final String RESPALDO_CIERRE = "CR";

	public static final String REGISTRO = "REGISTRO";
	public static final String DESCARGA = "DESCARGA";
	public static final String FTP = "FTP";

	public static final String FILE_SEPARATOR = "/";
	public static final String IKTAN = "iktan";
	public static final String IKTAN_TRABAJO = "/trabajo/";
	public static final String IKTAN_MOVIL = "IKTANMOVIL";
	public static final String MOVIL = FILE_SEPARATOR.concat(IKTAN_MOVIL).concat(FILE_SEPARATOR);
	public static final String TRABAJO = FILE_SEPARATOR.concat(IKTAN_TRABAJO).concat(FILE_SEPARATOR);
	public static final String CLAVE_OPERATIVA = "/{clave_operativa}/";
	public static final String LOGS = "/logs/";
	public static final String DESCARGAS = "descargas/";
	public static final String RESPALDOS = "/respaldos/";
	public static final String RESPALDOS_LOCAL = "/respaldos/";
	public static final String ENVIOS_LOCAL = "/envios/";
	public static final String ZIP = "/zip/";
	public static final String TEMPORALES = "temporales/";
	public static final String CIERRES = "/cierres/";
	public static final String RECURSOS = "recursos/";
	public static final String IMAGENES = "/imagenes/";
	public static final String DOCUMENTOS = "/documentos/";
	public static final String ACTUALIZACIONES = "/actualiaciones/";
	public static final String VERSIONES = "/versiones/";
	public static final String VERSIONES_MOVIL = "/Versiones/";
	public static final String INSTALADORES = "/instaladores/";
	public static final String FOTOGRAFIAS = "/fotos/";
	public static final String MODELO = "/modelo/";
	public static final String MCC = "/mcc";
	public static final String INTERPRETE = "/interprete";
	public static final String MAPAS = "/mapas";
	public static final String SENTENCIAS = "/sentencias/";
	public static final String WEB = "/web/";

	public static final String MOVIL_RESPALDOS = MOVIL.concat(CLAVE_OPERATIVA);
	public static final String MOVIL_ENVIOS = MOVIL.concat(CLAVE_OPERATIVA).concat(ENVIOS_LOCAL);
	public static final String MOVIL_FOTOS = MOVIL.concat(CLAVE_OPERATIVA).concat(FOTOGRAFIAS);
	public static final String MOVIL_VERSIONES = MOVIL.concat(VERSIONES_MOVIL);
	public static final String TRABAJO_MODELO = TRABAJO.concat(MODELO);
	public static final String TRABAJO_TEMPORALES = TRABAJO.concat(TEMPORALES);
	public static final String TRABAJO_CLAVE_OPERATIVA = TRABAJO.concat(CLAVE_OPERATIVA);
	public static final String TRABAJO_CLAVE_OPERATIVA_RESPALDOS = TRABAJO_CLAVE_OPERATIVA.concat(RESPALDOS);
	public static final String TRABAJO_CLAVE_OPERATIVA_ENVIOS = TRABAJO_CLAVE_OPERATIVA.concat(ENVIOS_LOCAL);
	public static final String TRABAJO_CLAVE_OPERATIVA_FOTOGRAFIAS = TRABAJO_CLAVE_OPERATIVA.concat(FOTOGRAFIAS);
	public static final String TRABAJO_CLAVE_OPERATIVA_MCC = TRABAJO_CLAVE_OPERATIVA.concat(MCC);

	public static final String TRABAJO_LOGS = TRABAJO.concat(LOGS);
	public static final String TRABAJO_LOGS_IKTAN = TRABAJO_LOGS.concat(FILE_SEPARATOR).concat(IKTAN);
	public static final String TRABAJO_LOGS_INTERPRETE = TRABAJO_LOGS.concat(INTERPRETE);

	public static final String IKTAN_DESCARGAS = TRABAJO.concat(DESCARGAS);

	public static final String IKTAN_ENVIOS = TRABAJO.concat(ENVIOS_LOCAL);
	public static final String IKTAN_ENVIOS_ZIP = IKTAN_ENVIOS.concat(ZIP).concat(FILE_SEPARATOR);
	public static final String IKTAN_ENVIOS_TEMPORALES = IKTAN_ENVIOS.concat(TEMPORALES);
	public static final String IKTAN_ENVIOS_TEMPORALES_SENTENCIAS = IKTAN_ENVIOS_TEMPORALES.concat(SENTENCIAS);

	public static final String IKTAN_CIERRES = TRABAJO.concat(CIERRES);
	public static final String IKTAN_CIERRES_TEMPORALES = IKTAN_CIERRES.concat(TEMPORALES);

	public static final String IKTAN_RECURSOS = TRABAJO.concat(RECURSOS);
	public static final String IKTAN_RECURSOS_IMAGENES = TRABAJO.concat(RECURSOS).concat(IMAGENES);
	public static final String IKTAN_RECURSOS_DOCUMENTOS = TRABAJO.concat(RECURSOS).concat(DOCUMENTOS);

	public static final String IKTAN_TRABAJO_MAPAS = TRABAJO.concat("trabajo").concat(MAPAS);

	public static final String IKTAN_ACTUALIZACIONES = TRABAJO.concat(ACTUALIZACIONES);
	public static final String IKTAN_ACTUALIZACIONES_VERSIONES = IKTAN_ACTUALIZACIONES.concat(VERSIONES);
	public static final String IKTAN_ACTUALIZACIONES_INSTALADORES = IKTAN_ACTUALIZACIONES.concat(INSTALADORES);

	public static final String IKTAN_FOTOGRAFIAS = TRABAJO.concat(FOTOGRAFIAS);
	public static final String IKTAN_FOTOGRAFIAS_ZIP = IKTAN_FOTOGRAFIAS.concat(ZIP);
	public static final String IKTAN_FOTOGRAFIAS_TEMPORALES = IKTAN_FOTOGRAFIAS.concat(TEMPORALES);

	public static final String DML_SELECT = "row";
	public static final String DML_VACIO = "";
	public static final String DML_DEFAULT = "1=1";

	public static final String XML_SENTENCIAS_IKTAN = "mx/org/inegi/movil/db/xml/movil.xml";
	public static final String XML_VISTAS_IKTAN = "mx/org/inegi/movil/db/xml/vistas.xml";
	public static final String XML_MENSAJES_IKTAN = "mx/org/inegi/movil/db/xml/mensajes.xml";

	public static final String XML_SENTENCIAS_PROYECTO = "mx/org/inegi/{proyecto}/db/xml/{proyecto}.xml";
	public static final String XML_VISTAS_PROYECTO = "mx/org/inegi/{proyecto}/db/xml/vistas.xml";
	public static final String XML_MENSAJES_PROYECTO = "mx/org/inegi/{proyecto}/db/xml/mensajes.xml";

	// Constantes de separadores y caracteres
	public static final String SEPARADOR = "|";
	public static final String SEPARADOR_SPLIT = "\\|";
	public static final String TILDE = "~";
	public static final String CIRCUNFLEJO = "^";
	public static final String ASTERISCO = "*";
	public static final String AMPERSON = "&";
	public static final String COMILLA = "'";
	public static final String ARROBA = "@";
	public static final String COMA = ",";

	//Constantes de SQL
	public static final String SQL_RESERVADO = "params";
	public static final String SQL_CONDICION = "condicion";
	public static final String SQL_VERDADERO = "1=1";
	public static final long SQL_MAXIMO_REGISTROS = 100L;
	public static final long SQL_TOPE_REGISTROS = 2000L;
	public static final long SQL_TODOS_REGISTROS = -1L;
	public static final int SQL_PRIMER_REGISTRO = 1;
	public static final int SI = 1;
	public static final int NO = 2;

	//Constantes de cuentas
	public static final String CUENTA_SUPER_USR = "ADMIN";
	public static final String CUENTA_SOPORTE = "IKTAN.SOPORTE";

	public static final String KEY_ENCRYPTION = "3scu3l@s2013IKTAN";

	public static final String NOMBRE_ALIAS_APLICACION = "seco";
	public static final String NOMBRE_FORMULARIO = ":datos:";
	public static final String RUTA_CLASES = "/WEB-INF/classes/";
	public static final String RUTA_TEMPORALES = "Temporal/";
	public static final String RUTA_IMAGENES_MENU = "/resources/iktan/icon/menu/";
	public static final String RUTA_IMAGENES = "/resources/iktan/img/sistema/";
	public static final String REDIRECIONAR = "?faces-redirect=true";
	public static final String REDIRECIONAR_AMPERSON = "&faces-redirect=true";
	public static final String JAVAX_FACES_RESOURCE = "javax.faces.resource";
	public static final String ESCUELAS_ACTUALIZACIONES = "/Escuelas/Actualizaciones/";

	public static final String ESPACIO = "&nbsp;";
	public static final String BR = "<br>";
	public static final String EOL = "\r\n";
	public static final String ENTER = "\n";
	public static final String ARCHIVO_PATRON_SEPARADOR = "_";
	public static final String ARCHIVO_PATRON_NOMBRE = "xIktan";
	public static final String NOMBRE_ARCHIVO_DEFAULT = "SinNombre";
	public static final String ARCHIVO_KEY_USB = "iktan.key";
	public static final String EXT_CODIFICACION = ".INEGI";
	public static final String CAMPO_LLAVE = "id";
	public static final String NOMBRE_FINAL_CLASE_DTO = "Dto";
	public static final String NOMFILE_DEFAULT_VERSION = "IktanUpdate";
	public static final String NOMFILE_DEFAULT_MCC = "IktanMcc";
	public static final String ATRIBUTO_BLOQUEO_USUARIOS = "bloqueoUsuario";

	//Constantes para la lectura del xml
	public static final String DML_IDENTICO = "identically";
	public static final String DML_DINAMICO = "dinamico";
	public static final String DML_ACTUALIZAR_TODOS = "rows";
	public static final String DML_ELIMINAR_TODOS = "rows";
	public static final String DML_RESERVADO = "view";
	public static final String XML_PROYECTO_LOAD = "load";
	public static final String XML_PROYECTO_PARTIAL = "partial";
	public static final String XML_PROYECTO_JAR = "jar";
	public static final String XML_PROYECTO_MAPPING = "mapping";
	public static final String XML_PROYECTO_BEANS = "backing";
	public static final String XML_PROYECTO_DTO = "dto";
	public static final String XML_PROYECTO_ID = "id";
	public static final String XML_PROYECTO_MSG = "msg";

	// Constates para importar archivos
	public static final String RUTA_IMPORTADOS = RUTA_TEMPORALES.concat("/Files/");
	public static final String RUTA_IMPORTADOS_DBF = RUTA_TEMPORALES.concat("/Dbf/");
	public static final String IMPORTAR_REFERENCIA = "IKTAN_IMPORTAR";

	// Constantes para REPORTES
	public static final String REPORTE_REFERENCIA = "IKTAN_REPORTE";
	public static final String REPORTE_SQL = "REPORTE_SQL";
	public static final String REPORTE_REGISTROS = "REPORTE_REGISTROS";
	public static final String REPORTE_IMAGENES = "REPORTE_IMAGENES";
	public static final String REPORTE_TITULOS = "REPORTE_TITULOS";
	public static final String REPORTE_SUBREPORTE = "REPORTE_SUBREPORTE";
	public static final String REPORTE_VERSION = "REPORTE_VERSION";
	public static final String REPORTE_PREVIEW = "REPORTE_PREVIEW";

	public static final Long USUARIO_ACTIVO = 1L;
	public static final String PERMITIR_ACCESO = "1";

	public static final String PROPIEDAD_SISTEMA_SERVIDOR = "sistema.servidor";
	public static final String PROPIEDAD_SISTEMA = "sistema";
	public static final String PROPIEDAD_TEMPORALES = "temporales";
	public static final String SEPARADOR_PROPIEDADES = ".";

	public static final String MENSAJE_SISTEMA = "Mensaje del sistema";
	//Atributo autentifica
	public static final String ATRIBUTO_AUTENTIFICA = "autentifica";
	//Atributo para usuarios del sitio
	public static final String ATRIBUTO_USUARIOS_SITIO = "usuariosSitio";

	//Atributos utilizados para las tablas en las paginas de filtro
	public static final String NO_EXISTEN_REGISTROS = "No existen registros";
	public static final int REGISTROS_POR_PAGINA = 15;
	public static final String ICONOS_DE_PAGINACION = "{CurrentPageReport}  {FirstPageLink} {PreviousPageLink} {PageLinks} {NextPageLink} {LastPageLink} {RowsPerPageDropdown}";
	public static final String REGISTROS_POR_CADA_PAGINA = "10,15,20";

	//Atributo que indica que estilo se estable como inicial en el sistema
	public static final String TEMA_INICIAL = "home";
	public static final String SECO_VISTA_DINAMICO = "seco0DvistaDinamico";

	// Constantes de inicio y salida del sistema
	public static final String CLAVE_ACCESO_SISTEMA = "0001";
	public static final String CLAVE_SALIDA_SISTEMA = "0002";
	public static final String CLAVE_MODULO_SECO = "0000";

	public static final String PAQUETE_DEFAULT_DB = "mx.org.dao.seco.db.";
	public static final String PAQUETE_TRANSFORMACION = "mx.org.dao.seco.procesos.";
	public static final String PAQUETE_MANAGED_BEAN_REGISTER = "mx.org.dao.";

	public static final int INTENTOS = 3;
	public static final int DIAS_CORTE = 3;

	public static final String GRAFICA_REFERENCIA = "IKTAN_GRAFICA";
	public static final String RECARGA = "ConfiguracionesIktan2015";

	public static final String PASSWORD_ZIP = "oX561r#Yn2%4wp$v";
	public static final String DIRECTORIO_WS_CLAVE_APPLICACION = "DGA_JAVA_IKTAN";
	public static final String MIME_APK = "application/vnd.android.package-archive";

	public static final String LANZADOR_INTERPRETE = "LANZADOR";
	public static final String LANZADOR_PAGINA_INTERPRETE = "lanzador?faces-redirect=true";

	public static final int MAX_OPCIONES_ULTIMO_NIVEL = 12;

	// Constantes para mantenimiento de encuestas
	public static final int MINDMAP_MIN_PERFILES = 2;
	public static final int MINDMAP_MIN_OFICINAS = 7;
	public static final int MINDMAP_MIN_MENUS = 3;
	public static final int MINDMAP_MIN_USUARIOS = 1;
	public static final int MINDMAP_MIN_USUARIOS_AGREGADOS = 0;


	// Constantes para el dominio

	public static final String DOMINIO_GOB = "inegi.org.mx";
	public static final String DOMINIO_GOB_ARROBA = ARROBA.concat(DOMINIO_GOB);
	public static final String DOMINIO_ORG = "inegi.org.mx";
	public static final String DOMINIO_ORG_ARROBA = ARROBA.concat(DOMINIO_ORG);

	// nombre de perfiles base

	public static final String PERFIL_ADMINISTRADOR_ENCUESTA = "ADMINISTRADOR DE ENCUESTA";
	public static final String PERFIL_ADMINISTRADOR = "ADMINISTRADOR";
	public static final String PERFIL_JEFE_SISTEMAS = "JEFE DE SISTEMAS";

	public String getNO_EXISTEN_REGISTROS() {
		return Constantes.NO_EXISTEN_REGISTROS;
	}

	public Integer getREGISTROS_POR_PAGINA() {
		return Constantes.REGISTROS_POR_PAGINA;
	}

	public String getICONOS_DE_PAGINACION() {
		return Constantes.ICONOS_DE_PAGINACION;
	}

	public String getREGISTROS_POR_CADA_PAGINA() {
		return Constantes.REGISTROS_POR_CADA_PAGINA;
	}

	protected Constantes() {
	}
}