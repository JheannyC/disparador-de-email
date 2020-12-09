package com.ufpb.crm;

import com.opencsv.CSVReader;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Disparador {

    private static final String CSV_PATH = "src/main/resources/dados.csv";



    public static void main(String[] args) {


        try {
            CSVReader csvReader = new CSVReader(new FileReader(new File(CSV_PATH)));
            List<List<String>> linhas = new ArrayList<List<String>>();
            String[] colunas = null;

            while ((colunas = csvReader.readNext()) != null) {


                for (int i = 0; i < colunas.length; i++) {

                    linhas.add(Arrays.asList(colunas));

                }


               if ((colunas[9].equals("Vendedor (a)") && colunas[4].equals("31 a 50 anos")) &&
                        (colunas[6].equals("SOLTEIRO")) && (colunas[7].equals("JOÃO_PESSOA") && (colunas[8].equals("Bairros das Indústrias")))) {

                    Mensagem m1 = new Mensagem();
                    m1.enviarMensagem(colunas[14], "PERSONA 1", "Olá " + colunas[1] + "! \n\n" +
                            "Você é a persona 1!" +
                            "Estamos aqui para te oferecer nossos melhores produTos!");

                }
                if ((colunas[9].equals("aposentado") && colunas[4].equals("maior que 50 anos")) &&
                        (colunas[6].equals("DIVORCIADO")) && (colunas[7].equals("RECIFE") && (colunas[8].equals("Alto José do Pinho")) &&
                        (colunas[10].equals("0")))) {

                    Mensagem m2 = new Mensagem();
                    m2.enviarMensagem(colunas[14], "PERSONA 2", "Olá " + colunas[1] + "! \n\n" +
                            "Você é a persona 2!" +
                            "Estamos aqui para te oferecer nossos melhores produTos!");

                }
                if ((colunas[9].equals("Estudante") && colunas[4].equals("18 a 30 anos")) &&
                        (colunas[6].equals("SOLTEIRO")) && (colunas[7].equals("JOÃO_PESSOA"))) {

                    Mensagem m3 = new Mensagem();
                    m3.enviarMensagem(colunas[14], "PERSONA 3", "Olá " + colunas[1] + "! \n\n" +
                            "Você é a persona 3!" +
                            "Estamos aqui para te oferecer nossos melhores produTos!");

                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}

/*linhas.forEach(cols -> {
                //System.out.println("\n");
                //System.out.println(cols.get(2));

            });*/

