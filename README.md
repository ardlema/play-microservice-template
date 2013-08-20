play-microservice-template
==========================

Plantilla giter8 para crear de forma sencilla microservicios implementados sobre el framework Play

Resolución de problemas
=======================

Si utilizas la plantilla sobre OSX con JDK 7 al intentar arrancar la aplicación se mostrará el siguiente mensaje de error:

Caused by: java.net.UnknownHostException: [HOSTNAME_NAME]: nodename nor servname provided, or not known

Este error se debe a un problema con esta versión de la JDK para OSX que no reconoce el hostname como localhost.

Para solucionarlo se debe ejecutar el siguiente comando:

$ sudo echo "127.0.0.1 [YOUR_HOSTNAME]" >> /etc/hosts

IMPORTANTE: No eliminar la entrada "127.0.0.1 localhost" en /etc/hosts.
