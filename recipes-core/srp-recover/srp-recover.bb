DESCRIPTION = "SRP Initscripts"
LICENSE = "CLOSED" 
 
SRC_URI += "\
    file://srp_recover.sh \
"
 
INITSCRIPT_NAME = "srp_recover.sh" 
INITSCRIPT_PARAMS = "start 99 5 ." 
 
inherit update-rc.d 
 
S = "${WORKDIR}" 
 
do_install () { 
    install -d ${D}${sysconfdir}/init.d/ 
    install -c -m 755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME} 
} 

DEPENDS = "bash"

RDEPENDS:${PN} = "bash"
