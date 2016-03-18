package com.chazknox.mashgamefinal;

/**
 * Created by chazk on 3/15/2016.
 */
public class Entry {

    private int _id;
    private String _entry;
    private String _name;
    private String _kids;
    private String _job;
    private String _home;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_entry() {
        return _entry;
    }

    public void set_entry(String _entry) {
        this._entry = _entry;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_kids() {
        return _kids;
    }

    public void set_kids(String _kids) {
        this._kids = _kids;
    }

    public String get_job() {
        return _job;
    }

    public void set_job(String _job) {
        this._job = _job;
    }

    public String get_home() {
        return _home;
    }

    public void set_home(String _home) {
        this._home = _home;
    }

    public Entry() { }

    public Entry(String entry) {_entry = entry;}

    public Entry(String name, String kids, String job, String home) {
            _name = name;
            _kids = kids;
            _job = job;
            _home = home;
            }

}
