/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irrcyn.internal.nodefilter;

import de.bioquant.cytoscape.pidfileconverter.Model.InteractionNode;
import irrcyn.internal.parser.Node;
import irrcyn.internal.parser.Nodes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.util.ArrayList;


/**
 *
 * @author Amine
 */
public class HashMapUniprot {
    
    private Map<String, ArrayList <String>> ID_UNIPROTMap = new HashMap<String,ArrayList <String>> ();
    private String TargetCSVpath;
    private File InfoFile;
    private Nodes nodes;
    private String infoLabel;
    String line = "";
    String split = "=";
    private BufferedReader br = null;

    public HashMapUniprot(String TargetCSVpath, File InfoFile, Nodes nodes, String infoLabel) {
        this.TargetCSVpath = TargetCSVpath;
        this.InfoFile = InfoFile;
        this.nodes = nodes;
        this.infoLabel = infoLabel;
        
        
    }

    public HashMapUniprot() {
    }
    
    
    public void CSVtoMap () throws IOException {
        String CurId = "";
        String CurUniprot = "";//création d'un String pour l'uniprot et pour l'id
        Node currentNode;
        
        try {
         br = new BufferedReader(new FileReader(TargetCSVpath));//buffer reader

        line = br.readLine();//stockage de la ligne 1 du csv (Info Label)
        infoLabel = line.split(split)[0].trim();
        
       
        
        
        
        //Boucle while de parcours général, s'arrete quand il n'y a plus d'uniprot a verifier
            //boucle de parcours (read while) 
                    while ((line = br.readLine()) != null) { // pour chaque ligne du fichier courrant
                      
                      if (!(line.split(split)[1].trim()).equals("")) {
                          
                        CurId = line.split(split)[0].trim(); // On ajoute le noeud ou on le récupère
                        CurUniprot = line.split(split)[1].trim(); // On ajoute l'attribut au noeud
                        
                        if (ID_UNIPROTMap.containsKey(CurUniprot)) {
                            
                            ID_UNIPROTMap.get(CurUniprot).add(CurId);
                            
                        }else {
                             ArrayList<String> ListId = new ArrayList<String> ();
                             ListId.add(CurId);
                             ID_UNIPROTMap.put(CurUniprot, ListId);
                        }
                         
                      }
                    
                }   
                    
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        
                 //recuperation de l'uniprot
                 //parcours de tout le fichier pour recuperer les id de l'uniprot courant
                    // l'uniprot est marqué comme 'traité' 
         
        //fin
            
        
    }

    public Map<String, ArrayList<String>> getID_UNIPROTMap() {
        return ID_UNIPROTMap;
    }

    public void setID_UNIPROTMap(Map<String, ArrayList<String>> ID_UNIPROTMap) {
        this.ID_UNIPROTMap = ID_UNIPROTMap;
    }

    public String getTargetCSVpath() {
        return TargetCSVpath;
    }

    public void setTargetCSVpath(String TargetCSVpath) {
        this.TargetCSVpath = TargetCSVpath;
    }

    public File getInfoFile() {
        return InfoFile;
    }

    public void setInfoFile(File InfoFile) {
        this.InfoFile = InfoFile;
    }

    public Nodes getNodes() {
        return nodes;
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }

    public String getInfoLabel() {
        return infoLabel;
    }

    public void setInfoLabel(String infoLabel) {
        this.infoLabel = infoLabel;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }
    
    

    
    
    
    
    
    
    
    
}
