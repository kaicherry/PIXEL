//
// Decompiled by Procyon v0.5.36
//

package org.ini4j;

import org.ini4j.spi.IniBuilder;
import java.io.FileOutputStream;
import org.ini4j.spi.IniHandler;
import org.ini4j.spi.IniFormatter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import org.ini4j.spi.IniParser;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.net.URL;
import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.File;

public class Ini extends BasicProfile implements Persistable, Configurable
{
    private static final long serialVersionUID = -6029486578113700585L;
    private Config _config;
    private File _file;

    public Ini() {
        this._config = Config.getGlobal();
    }

    public Ini(final Reader input) throws IOException, InvalidFileFormatException {
        this();
        this.load(input);
    }

    public Ini(final InputStream input) throws IOException, InvalidFileFormatException {
        this();
        this.load(input);
    }

    public Ini(final URL input) throws IOException, InvalidFileFormatException {
        this();
        this.load(input);
    }

    public Ini(final File input) throws IOException, InvalidFileFormatException {
        this();
        this._file = input;
        this.load();
    }

    public Config getConfig() {
        return this._config;
    }

    public void setConfig(final Config value) {
        this._config = value;
    }

    public File getFile() {
        return this._file;
    }

    public void setFile(final File value) {
        this._file = value;
    }

    public void load() throws IOException, InvalidFileFormatException {
        if (this._file == null) {
            throw new FileNotFoundException();
        }
        this.load(this._file);
    }

    public void load(final InputStream input) throws IOException, InvalidFileFormatException {
        this.load(new InputStreamReader(input, this.getConfig().getFileEncoding()));
    }

    public void load(final Reader input) throws IOException, InvalidFileFormatException {
        IniParser.newInstance(this.getConfig()).parse(input, this.newBuilder());
    }

    public void load(final File input) throws IOException, InvalidFileFormatException {
        this.load(input.toURI().toURL());
    }

    public void load(final URL input) throws IOException, InvalidFileFormatException {
        IniParser.newInstance(this.getConfig()).parse(input, this.newBuilder());
    }

    public void store() throws IOException {
        if (this._file == null) {
            throw new FileNotFoundException();
        }
        this.store(this._file);
    }

    public void store(final OutputStream output) throws IOException {
        this.store(new OutputStreamWriter(output, this.getConfig().getFileEncoding()));
    }

    public void store(final Writer output) throws IOException {
        this.store(IniFormatter.newInstance(output, this.getConfig()));
    }

    public void store(final File output) throws IOException {
        final OutputStream stream = new FileOutputStream(output);
        this.store(stream);
        stream.close();
    }

    protected IniHandler newBuilder() {
        return IniBuilder.newInstance(this);
    }

    protected void store(final IniHandler formatter, final Profile.Section section) {
        if (this.getConfig().isEmptySection() || section.size() != 0) {
            super.store(formatter, section);
        }
    }

    protected void store(final IniHandler formatter, final Profile.Section section, final String option, final int index) {
        if (this.getConfig().isMultiOption() || index == section.length(option) - 1) {
            super.store(formatter, section, option, index);
        }
    }

    @Override
    boolean isTreeMode() {
        return this.getConfig().isTree();
    }

    @Override
    char getPathSeparator() {
        return this.getConfig().getPathSeparator();
    }

    @Override
    boolean isPropertyFirstUpper() {
        return this.getConfig().isPropertyFirstUpper();
    }
}
