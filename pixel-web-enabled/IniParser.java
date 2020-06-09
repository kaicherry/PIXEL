//
// Decompiled by Procyon v0.5.36
//

package org.ini4j.spi;

import java.util.Locale;
import java.net.URL;
import java.io.Reader;
import org.ini4j.InvalidFileFormatException;
import java.io.IOException;
import java.io.InputStream;
import org.ini4j.Config;

public class IniParser extends AbstractParser
{
    private static final String COMMENTS = ";#";
    private static final String OPERATORS = ":=";
    static final char SECTION_BEGIN = '[';
    static final char SECTION_END = ']';

    public IniParser() {
        super(":=", ";#");
    }

    public static IniParser newInstance() {
        return ServiceFinder.findService(IniParser.class);
    }

    public static IniParser newInstance(final Config config) {
        final IniParser instance = newInstance();
        instance.setConfig(config);
        return instance;
    }

    public void parse(final InputStream input, final IniHandler handler) throws IOException, InvalidFileFormatException {
        this.parse(this.newIniSource(input, handler), handler);
    }

    public void parse(final Reader input, final IniHandler handler) throws IOException, InvalidFileFormatException {
        this.parse(this.newIniSource(input, handler), handler);
    }

    public void parse(final URL input, final IniHandler handler) throws IOException, InvalidFileFormatException {
        this.parse(this.newIniSource(input, handler), handler);
    }

    private void parse(final IniSource source, final IniHandler handler) throws IOException, InvalidFileFormatException {
        handler.startIni();
        String sectionName = null;
        for (String line = source.readLine(); line != null; line = source.readLine()) {
            if (line.charAt(0) == '[') {
                if (sectionName != null) {
                    handler.endSection();
                }
                sectionName = this.parseSectionLine(line, source, handler);
            }
            else {
                if (sectionName == null) {
                    if (this.getConfig().isGlobalSection()) {
                        sectionName = this.getConfig().getGlobalSectionName();
                        handler.startSection(sectionName);
                    }
                    else {
                        this.parseError(line, source.getLineNumber());
                    }
                }
                this.parseOptionLine(line, handler, source.getLineNumber());
            }
        }
        if (sectionName != null) {
            handler.endSection();
        }
        handler.endIni();
    }

    private String parseSectionLine(final String line, final IniSource source, final IniHandler handler) throws InvalidFileFormatException {
        if (line.charAt(line.length() - 1) != ']') {
            this.parseError(line, source.getLineNumber());
        }
        String sectionName = this.unescapeKey(line.substring(1, line.length() - 1).trim());
        if (sectionName.length() == 0 && !this.getConfig().isUnnamedSection()) {
            this.parseError(line, source.getLineNumber());
        }
        if (this.getConfig().isLowerCaseSection()) {
            sectionName = sectionName.toLowerCase(Locale.getDefault());
        }
        handler.startSection(sectionName);
        return sectionName;
    }
}
