FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://99-zram-sysctl.conf"

do_install:append() {
    install -d ${D}${sysconfdir}/sysctl.d
    install -m 0644 ${WORKDIR}/99-zram-sysctl.conf ${D}${sysconfdir}/sysctl.d/
}

FILES:${PN} += "${sysconfdir}/sysctl.d/99-zram-sysctl.conf"
