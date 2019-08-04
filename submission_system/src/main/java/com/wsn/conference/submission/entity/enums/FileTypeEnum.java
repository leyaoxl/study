package com.wsn.conference.submission.entity.enums;

public enum FileTypeEnum {
    /**
     * JEPG.
     */
    JPEG("JPEG", "FFD8FF"),

    /**
     * PNG.
     */
    PNG("PNG", "89504E47"),

    /**
     * GIF.
     */
    GIF("GIF", "47494638"),

    /**
     * TIFF.
     */
    TIFF("TIFF", "49492A00"),

    /**
     * Windows Bitmap.
     */
    BMP("BMP", "424D"),

    /**
     * CAD.
     */
    DWG("DWG", "41433130"),

    /**
     * Adobe Photoshop.
     */
    PSD("PSD", "38425053"),

    /**
     * Rich Text Format.
     */
    RTF("RTF", "7B5C727466"),

    /**
     * XML.
     */
    XML("XML", "3C3F786D6C"),

    /**
     * HTML.
     */
    HTML("HTML", "68746D6C3E"),

    /**
     * Email [thorough only].
     */
    EML("EML", "44656C69766572792D646174653A"),

    /**
     * Outlook Express.
     */
    DBX("DBX", "CFAD12FEC5FD746F"),

    /**
     * Outlook (pst).
     */
    PST("PST", "2142444E"),

    /**
     * MS Word/Excel.
     */
    XLS_DOC("XLS_DOC", "D0CF11E0"),

    /**
     * MS Access.
     */
    MDB("MDB", "5374616E64617264204A"),

    /**
     * WordPerfect.
     */
    WPD("WPD", "FF575043"),

    /**
     * Postscript.
     */
    EPS("EPS", "252150532D41646F6265"),

    /**
     * Adobe Acrobat.
     */
    PDF("PDF", "255044462D312E"),

    /**
     * Quicken.
     */
    QDF("QDF", "AC9EBD8F"),

    /**
     * Windows Password.
     */
    PWL("PWL", "E3828596"),

    /**
     * ZIP Archive.
     */
    ZIP("ZIP", "504B0304"),

    /**
     * RAR Archive.
     */
    RAR("RAR", "52617221"),

    /**
     * Wave.
     */
    WAV("WAV", "57415645"),

    /**
     * AVI.
     */
    AVI("AVI", "41564920"),

    /**
     * Real Audio.
     */
    RAM("RAM", "2E7261FD"),

    /**
     * Real Media.
     */
    RM("RM", "2E524D46"),

    /**
     * MPEG (mpg).
     */
    MPG("MPG", "000001BA"),

    /**
     * Quicktime.
     */
    MOV("MOV", "6D6F6F76"),

    /**
     * Windows Media.
     */
    ASF("ASF", "3026B2758E66CF11"),

    /**
     * MIDI.
     */
    MID("MID", "4D546864");

    private String type = "";
    private String value = "";

    FileTypeEnum(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
