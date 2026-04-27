SUMMARY = "Example recipe for using inherit useradd"
DESCRIPTION = "This recipe serves as an example for using features from useradd.bbclass"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://file1 \
           file://file2 \
           file://file3 \
           file://file4"

S = "${UNPACKDIR}"

inherit useradd

PACKAGES =+ "${PN}-user3"

# You must set USERADD_PACKAGES when you inherit useradd. This
# lists which output packages will include the user/group
# creation code.
USERADD_PACKAGES = "${PN} ${PN}-user3"

# You must also set USERADD_PARAM and/or GROUPADD_PARAM when
# you inherit useradd.

# USERADD_PARAM specifies command line options to pass to the
# useradd command. Multiple users can be created by separating
# the commands with a semicolon. Here we'll create two users,
# user1 and user2:

GROUPADD_PARAM:${PN} = "-g 1000 srp ; -g 1001 logs ; -g 1002 persistence ; -g 1003 com ; -g 890 group2;--system gpio;--system i2c;--system tty;--system bin"

# Likewise, we'll manage group3 in the useradd-example-user3 package:
GROUPADD_PARAM:${PN}-user3 = "-g 900 group3"

USERADD_PARAM:${PN} = "-u 1000 -d /home/srpapp -r -s /bin/bash --groups srp,gpio,i2c,tty,bin,logs,persistence,com srpapp"

# user3 will be managed in the useradd-example-user3 package:
# As an example, we use the -p option to set password ('user3') for user3
USERADD_PARAM:${PN}-user3 = "-u 1202 -d /home/user3 -r -s /bin/bash -p '\$6\$XAWr.8nc\$bUE4pYYaVb8n6BbnBitU0zeJMtfhTpFpiOBLL9zRl4e4YQo88UU4r/1kjRzmTimCy.BvDh4xoFwVqcO.pihLa1' user3"


GROUPADD_PARAM:${PN}-user3 = "-g 900 group3"

do_install () {
	install -d -m 755 ${D}${datadir}/srpapp
	install -d -m 755 ${D}${datadir}/user3
	install -p -m 644 ${UNPACKDIR}/file1 ${D}${datadir}/srpapp/

	install -p -m 644 ${UNPACKDIR}/file3 ${D}${datadir}/user3/
	install -p -m 644 ${UNPACKDIR}/file4 ${D}${datadir}/user3/
	install -d ${D}/persistence
    install -d ${D}/logs
    chmod 0666 ${D}/persistence
    chmod 0666 ${D}/logs
}

do_rootfs() {
	chgrp -R persistence ${D}/persistence
	chgrp -R logs ${D}/logs
	chgrp -R com ${D}/run
}

FILES:${PN} = "${datadir}/srpapp/* \
				/logs \
				/persistence \
"
FILES:${PN}-user3 = "${datadir}/user3/*"

# Prevents do_package failures with:
# debugsources.list: No such file or directory:
# INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
