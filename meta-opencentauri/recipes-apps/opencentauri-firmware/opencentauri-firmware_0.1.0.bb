SUMMARY = "OpenCentauri firmware files"
DESCRIPTION = "All supporting firmware files and config files"
HOMEPAGE = "https://github.com/OpenCentauri/OpenCentauri"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://opencentauri-firmware-init-d;md5=0d38b88466a31c9b775d5ecfca65fc04"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://dsp.elf \
    file://opencentauri-firmware-init-d"

S = "${WORKDIR}"

inherit update-rc.d

RDEPENDS:${PN} = " \
    kalico \
"

INITSCRIPT_NAME = "opencentauri-firmware"
INITSCRIPT_PARAMS = "defaults 94 4"

do_configure() {
    :
}

do_compile() {
    :
}

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
# We are including an elf file for a different arch, so don't look at it
INSANE_SKIP:${PN} = "arch"

do_install() {
    # Install dsp firmware
    install -d ${D}/lib/firmware
    cp -r ${S}/dsp.elf ${D}/lib/firmware/rproc-1700000.dsp-fw

    # Install SysVinit script
    install -d ${D}${sysconfdir}/init.d
    cp ${WORKDIR}/opencentauri-firmware-init-d ${D}${sysconfdir}/init.d/opencentauri-firmware
    chmod 0755 ${D}${sysconfdir}/init.d/opencentauri-firmware
}

FILES:${PN} = " \
    /lib/firmware/rproc-1700000.dsp-fw \
    ${sysconfdir}/init.d/opencentauri-firmware \
"
