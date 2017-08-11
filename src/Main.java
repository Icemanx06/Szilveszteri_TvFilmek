import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class filmek implements Comparable<filmek>{
    String film;
    int ido;
    LinkedList<nezo> nezok = new LinkedList<>();

   

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final filmek other = (filmek) obj;
        if (this.ido != other.ido) {
            return false;
        }
        if (!Objects.equals(this.film, other.film)) {
            return false;
        }
        if (!Objects.equals(this.nezok, other.nezok)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       
        sb.append(film).append(": ");
        for (int i = 0; i < nezok.size(); i++) {
            
            if(i != nezok.size()-1){
                sb.append(nezok.get(i)).append(", ");
            }else{
                sb.append(nezok.get(i));
            }
        }
        return sb.toString();
    }
    

    
    
    @Override
    public int compareTo(filmek o) {
        if(this.ido != o.ido){
            return -Integer.compare(this.ido, o.ido);
        }
        return this.film.compareTo(o.film);
    }
    
    
}

class nezo implements Comparable<nezo>{
    String nezo;

    public nezo(String nezo) {
        this.nezo = nezo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final nezo other = (nezo) obj;
        if (!Objects.equals(this.nezo, other.nezo)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(nezo o) {
        return this.nezo.compareTo(o.nezo);
    }

    @Override
    public String toString() {
        return  nezo;
    }
    
    
}
public class Main {
    public static void main(String[] args) {
        LinkedList<filmek> list = new LinkedList<>();
        LinkedList<filmek> list2 = new LinkedList<>();
//        try(Scanner sc = new Scanner(new File("sample2.txt"))){
          try(Scanner sc = new Scanner(new File(args[0]))){ 
            while(sc.hasNextLine()){
                String[] line = sc.nextLine().split(":");
                nezo nez = new nezo(line[0]);
                int hossz = line[1].split(";").length;
//                System.out.println(hossz);
                String[] filmek = line[1].split(";");
                for (int i = 0; i < filmek.length; i++) {
                    String[] egyfilm = filmek[i].split("->");
                    String[] idok = egyfilm[0].split("-");
                    String kezderre = idok[0].replace(".", ",");
                    String[] kezdes = kezderre.split(",");
                    String beferre = idok[1].replace(".", ",");
                    String[] befejezes = beferre.split(",");
                    int kezdora = Integer.parseInt(kezdes[0]);
                    int kezdperc =Integer.parseInt(kezdes[1]);
                    int befejora = Integer.parseInt(befejezes[0]);
                    int befejperc = Integer.parseInt(befejezes[1]);
                    int ido = 0;
//                    System.out.println(kezdperc);
                    if(kezdora<befejora){
                        ido = (((befejora-kezdora)*60)-60)+((60-kezdperc)+befejperc);

                    }else if(kezdora == befejora){
                        ido = (befejperc-kezdperc);
                    }else{
                        ido = (((24-kezdora)*60)-60)+(60-kezdperc)+((befejora*60)+befejperc);
                    }
                    int index = 0;
                    boolean van = false;
                    if(list.isEmpty()){
                        filmek ujfilm = new filmek();
                        ujfilm.ido = ido;
                        ujfilm.nezok.add(nez);
                        ujfilm.film = egyfilm[1];
                        list.add(ujfilm);                      
                    }else{
                        for (int j = 0; j < list.size(); j++) {
                            if((list.get(j).film.equals(egyfilm[1]))&&(list.get(j).ido == ido)){
                                van= true;
                                index = j;
                            }
                        }
                        if(van){
                            list.get(index).nezok.add(nez);
                            van = false;
                            index = 0;
                        }else{
                            filmek ujfilm = new filmek();
                            ujfilm.ido = ido;
                            ujfilm.nezok.add(nez);
                            ujfilm.film = egyfilm[1];
                            list.add(ujfilm);      
                        }
                    }
                    
//                        System.out.println(ido);
                    
                    
                    
                }
            }
            Collections.sort(list);
            list2.add(list.getFirst());
            int db = list2.get(0).ido;
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i).ido == db){
                    list2.add(list.get(i));
                }
            }
            for (filmek l : list2) {
                Collections.sort(l.nezok);
            }
            for (filmek object : list2) {
                System.out.println(object);
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
