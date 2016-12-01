/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irrcyn.internal.nodefilter;

import de.bioquant.cytoscape.pidfileconverter.FileWriter.FileWriter;
import irrcyn.internal.nodefilter.HashMapUniprot;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;

/**
 *
 * @author roumilishams
 */
public class NodeFilterTask extends AbstractTask {

    private String[] aParser;
    File f;
    String sourcesif;
    String targetsif;
    HashMapUniprot hashmap; // table de hachage qui contient les UNIPROT et les noms associés

    // For the buffer
    BufferedReader br = null;
    String line = "";   //ligne courante
    String split = " ";  //séparateur

    public NodeFilterTask(HashMapUniprot h, String source, String target) throws IOException {
        this.hashmap = h;
        this.targetsif = target;
        this.sourcesif = source;
        f = newFile(targetsif);
        f.createNewFile();

    }

    public void run(TaskMonitor taskMonitor) throws Exception {
        //ex de ligne courant d'un sif "P19174@cytoplasm	input	pid_i_204309"
        String id1; //stock le 1er id de la ligne courante
        String curlink; //stock le lien courant
        String id2;  //stock le 2er id de la ligne courante

        // Lecture
        for (String directory : aParser) {
            try {
                f = new File(sourcesif+"reduced.txt");
                br = new BufferedReader(new FileReader(sourcesif));
                java.io.FileWriter fw = new java.io.FileWriter(f.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter((Writer) fw);

                
                while ((line = br.readLine()) != null) {
                    line = br.readLine();
                    id1 = line.split(split)[0].trim();
                    curlink = line.split(split)[1].trim();
                    id2 = line.split(split)[2].trim();
                 for (Map.Entry<String, ArrayList <String>> e : hashmap.getID_UNIPROTMap().entrySet()) {
                 if(!e.getValue().equals(id1)){      //on compare l'id courant i de la table de hachage à celui du sif source id1
                 id1=e.getKey();//on récupère la clef associée à i (ie: son uniprot
                 break;//on sort de la boucle for si on rencontre l'id en question dans la table
                 }
                 }  //sinon on laisse id1 dans le target
                   
                 for (Map.Entry<String, ArrayList <String>> e : hashmap.getID_UNIPROTMap().entrySet()) {//puis on fait pareil pour id2
                 if(!e.getValue().equals(id2)){      
                 id2=e.getKey();
                 break;
                 } 
                }
                 //on recopie ensuite le lien modifié
                bw.newLine();   //(potentiellement un pb si on lit la 1ere ligne d'un sif deja traité car elle sera vide ??)
                bw.write(id1);
                bw.write("  ");
                bw.write(curlink);
                bw.write(id2);  
            } 
            bw.close();
             
        }
            catch (IOException exception) {
            System.err.println("Erreur lors de l'ecriture du SIF : " + exception.toString());
            }
    }
    }
    
    public void setaParser(String[] aParser) {
        this.aParser = aParser;
    }

    public void setF(File f) {
        this.f = f;
    }

    public void setSourcesif(String sourcesif) {
        this.sourcesif = sourcesif;
    }

    public void setTargetsif(String targetsif) {
        this.targetsif = targetsif;
    }

    public void setHashmap(HashMapUniprot hashmap) {
        this.hashmap = hashmap;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setSplit(String split) {
        this.split = split;
    }

    public String[] getaParser() {
        return aParser;
    }

    public File getF() {
        return f;
    }

    public String getSourcesif() {
        return sourcesif;
    }

    public String getTargetsif() {
        return targetsif;
    }

    public HashMapUniprot getHashmap() {
        return hashmap;
    }

    public BufferedReader getBr() {
        return br;
    }

    public String getLine() {
        return line;
    }

    public String getSplit() {
        return split;
    }

    private File newFile(String targetsif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
