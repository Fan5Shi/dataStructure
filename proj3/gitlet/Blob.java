package gitlet;

import java.io.File;
import java.io.Serializable;

/** Blob class, stores the information from each file.
 * @author Jilin He
 * */
public class Blob implements Serializable {
    /** Store file's name. */
    private String _filename;
    /** Store file's path. */
    private String _filepath;
    /** Store file's id, generated by Utils.sha1(). */
    private String _fileid;

    /** Default constructor. */
    public Blob() {
        this._fileid = null;
        this._filepath = null;
        this._filename = null;
    }

    /** Update the file's property into blob.
     * @param file is the one need to be updated. */
    public void blobAdd(File file) {
        _filename = file.getName();
        _filepath = file.getPath();
        String contents = Utils.readContentsAsString(file);
        _fileid = Utils.sha1(contents);
    }

    /** Get file's name of this blob.
     * @return file's name. */
    public String getFilename() {
        return _filename;
    }

    /** Set file's name for this blob.
     * @param filename is input. */
    public void setFilename(String filename) {
        this._filename = filename;
    }

    /** Get file's path of this blob.
     * @return file's path. */
    public String getFilepath() {
        return _filepath;
    }

    /** Set file's path for this blob.
     * @param filepath is input. */
    public void setFilepath(String filepath) {
        this._filepath = filepath;
    }

    /** Get file's id of this blob.
     * @return file's id. */
    public String getFileid() {
        return _fileid;
    }

    /** Set file's id for this blob.
     * @param fileid is input. */
    public void setFileid(String fileid) {
        this._fileid = fileid;
    }
}
