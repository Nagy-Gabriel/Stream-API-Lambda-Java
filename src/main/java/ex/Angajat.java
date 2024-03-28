package ex;

import java.time.LocalDate;

class Angajat
{

    String nume;
    String post;
    LocalDate data_angajarii;
    float salariu;

    public Angajat() {
    }

    public Angajat (String nume, String post, LocalDate data_angajarii, float salariu)
    {
        super();
        this.nume = nume;
        this.post = post;
        this.data_angajarii = data_angajarii;
        this.salariu = salariu;
    }

    public static void add(Angajat angajat) {
    }

    @Override
    public String toString()
    {
        return nume + ", " + post + ", " + data_angajarii + ", " + + salariu;
    }

    public String getNume()
    {
        return nume;
    }


    public String getPost()
    {
        return post;
    }

    public LocalDate getData_angajarii()
    {
        return data_angajarii;
    }

    public float getSalariu()
    {
        return salariu;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setData_angajarii(LocalDate data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    public void setSalariu(float salariu) {
        this.salariu = salariu;
    }
}