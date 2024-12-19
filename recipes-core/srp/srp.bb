DESCRIPTION = "SRP Initscripts"
LICENSE = "CLOSED" 
 
SRC_URI += "\
    file://srp_start.sh \
    file://start_up.sh \
    file://network_interface.sh \
"
 
INITSCRIPT_NAME = "srp_start.sh" 
INITSCRIPT_PARAMS = "start 99 5 2 ." 
 
inherit update-rc.d 
 
S = "${UNPACKDIR}" 
 
do_install () { 
    
    install -d ${D}/srp
    install -d ${D}/srp/opt
    install -d ${D}/srp/opt/cpu_simba

    install -d ${D}${sysconfdir}/init.d/ 
    install -c -m 755 ${UNPACKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME} 

    install -m 0777 ${UNPACKDIR}/network_interface.sh ${D}/srp/opt/cpu_simba
    install -m 0777 ${UNPACKDIR}/start_up.sh  ${D}/srp/opt/cpu_simba

} 

DEPENDS = "bash"

RDEPENDS:${PN} = "bash"

FILES:${PN} += "\
    /srp/opt/cpu_simba/start_up.sh \
    /srp/opt/cpu_simba/network_interface.sh  \
"