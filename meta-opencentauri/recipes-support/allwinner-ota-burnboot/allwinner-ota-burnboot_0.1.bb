SUMMARY = "Allwinner OTA Boot Burner"
HOMEPAGE = "https://github.com/jamesturton/allwinner-ota-burnboot"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://BootHead.h;beginline=1;endline=19;md5=e9660d58c5efc3682f53a4fd8fc43608"

SRC_URI = "git://github.com/jamesturton/allwinner-ota-burnboot.git;protocol=https;branch=main"
SRCREV = "9dec9cbf2c9f352ade616ec4d4249dcb845766c0"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${libdir}
    install -m 0755 libota-burnboot.so ${D}${libdir}/

    install -d ${D}${includedir}
    install -m 0644 OTA_BurnBoot.h ${D}${includedir}/
}

FILES:${PN} += "${libdir}/libota-burnboot.so"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""
