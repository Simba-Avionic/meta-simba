FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"


SRC_URI += "\
            file://devtool-fragment.cfg \
            file://0001-Replace_can_by_uart.patch \
"

