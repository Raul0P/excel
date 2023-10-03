package com.raul;

import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Acaomeu {

    private int menorConcurso4Dezenas;
    private int maiorConcurso4Dezenas;
    private int menorConcurso5Dezenas;
    private int maiorConcurso5Dezenas;
    private int menorConcurso6Dezenas;
    private int maiorConcurso6Dezenas;
    private BigDecimal menorValorPago4Dezenas = BigDecimal.valueOf(Double.MAX_VALUE);
    private BigDecimal menorValorPago5Dezenas = BigDecimal.valueOf(Double.MAX_VALUE);
    private BigDecimal menorValorPago6Dezenas = BigDecimal.valueOf(Double.MAX_VALUE);
    private BigDecimal maiorValorPago4Dezenas = BigDecimal.ZERO;
    private BigDecimal maiorValorPago5Dezenas = BigDecimal.ZERO;
    private BigDecimal maiorValorPago6Dezenas = BigDecimal.ZERO;

    Random random = new Random();

    private List<Sorteio> listaSorteios = new ArrayList<>();

    public List<Sorteio> getListaSorteios() {
        return listaSorteios;
    }

    public void setListaSorteios(List<Sorteio> listaSorteios) {
        this.listaSorteios = listaSorteios;
    }

    public void lerArqXlsxSorteio(BufferedInputStream buf) {
        try {
            try (XSSFWorkbook wb = new XSSFWorkbook(buf)) {
                Sheet sheet = wb.getSheetAt(0);
                Iterator<?> linhas = sheet.rowIterator();
                boolean primeiraLinha = true;

                while (linhas.hasNext()) {
                    XSSFRow linha = (XSSFRow) linhas.next();
                    Iterator<?> celulas = linha.cellIterator();
                    Sorteio sorteio = new Sorteio();
                    if (primeiraLinha) {
                        primeiraLinha = false;
                        continue;
                    }
                    while (celulas.hasNext()) {
                        XSSFCell celula = (XSSFCell) celulas.next();
                        int coluna = celula.getColumnIndex();

                        switch (coluna) {
                            case 0:
                                sorteio.setConcurso((int) celula.getNumericCellValue());
                                break;
                            case 1:
                                sorteio.setData_sorteio(celula.toString());
                                break;
                            case 2:
                                sorteio.setBola1((int) celula.getNumericCellValue());
                                break;
                            case 3:
                                sorteio.setBola2((int) celula.getNumericCellValue());
                                break;
                            case 4:
                                sorteio.setBola3((int) celula.getNumericCellValue());
                                break;
                            case 5:
                                sorteio.setBola4((int) celula.getNumericCellValue());
                                break;
                            case 6:
                                sorteio.setBola5((int) celula.getNumericCellValue());
                                break;
                            case 7:
                                sorteio.setBola6((int) celula.getNumericCellValue());
                                break;
                            case 8:
                                sorteio.setGanhadores_6_acertos((int) celula.getNumericCellValue());
                                break;
                            case 9:
                                sorteio.setUF(celula.toString());
                                break;
                            case 10:
                                sorteio.setRateio_6_acertos(converterParaBigDecimal(celula));
                                break;
                            case 11:
                                sorteio.setGanhadores_5_acertos((int) celula.getNumericCellValue());
                                break;
                            case 12:
                                sorteio.setRateio_5_acertos(converterParaBigDecimal(celula));
                                break;
                            case 13:
                                sorteio.setGanhadores_4_acertos((int) celula.getNumericCellValue());
                                break;
                            case 14:
                                sorteio.setRateio_4_acertos(converterParaBigDecimal(celula));
                                break;
                            case 15:
                                sorteio.setAcumulado_6_acertos(converterParaBigDecimal(celula));
                                break;
                            case 16:
                                sorteio.setArrecadacao_total(converterParaBigDecimal(celula));
                                break;
                            case 17:
                                sorteio.setEstimativa_premio(converterParaBigDecimal(celula));
                                break;
                            case 18:
                                sorteio.setAcumulado_Sorteio_Especial_Mega_da_Virada(converterParaBigDecimal(celula));
                                break;
                            case 19:
                                sorteio.setObservacao(celula.toString());
                                break;
                            default:
                                break;
                        }

                    }

                    listaSorteios.add(sorteio);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: na hora de abrir dos processos no formato XLXS");
        }
    }

    private BigDecimal converterParaBigDecimal(XSSFCell celula) {
        if (celula == null) {
            return BigDecimal.ZERO;
        }

        if (celula.getCellType() == CellType.NUMERIC) {
            return BigDecimal.valueOf(celula.getNumericCellValue());
        } else if (celula.getCellType() == CellType.STRING) {
            String valorString = celula.getStringCellValue().replaceAll("[^0-9.,]", "");

            try {
                valorString = valorString.replace(".", "").replace(",", ".");
                return new BigDecimal(valorString);
            } catch (NumberFormatException e) {
                System.err.println("Erro ao converter valor: " + valorString);
                return BigDecimal.ZERO;
            }
        }

        return BigDecimal.ZERO;
    }

    public Map<Integer, Integer> contarNumerosSorteados() {
        Map<Integer, Integer> contagemNumeros = new HashMap<>();

        for (int numero = 1; numero <= 60; numero++) {
            contagemNumeros.put(numero, 0);
        }

        for (Sorteio sorteio : listaSorteios) {
            for (int numero = 1; numero <= 60; numero++) {
                if (numero == sorteio.getBola1() || numero == sorteio.getBola2() || numero == sorteio.getBola3()
                        || numero == sorteio.getBola4() || numero == sorteio.getBola5()
                        || numero == sorteio.getBola6()) {
                    contagemNumeros.put(numero, contagemNumeros.get(numero) + 1);
                }
            }
        }

        return contagemNumeros;
    }

    public int contarConcursosSemGanhadores6Dezenas(List<Sorteio> listaSorteios) {
        int concursosSemGanhadores6Dezenas = 0;

        for (Sorteio sorteio : listaSorteios) {
            if (sorteio.getGanhadores_6_acertos() == 0) {
                concursosSemGanhadores6Dezenas++;
            }
        }

        return concursosSemGanhadores6Dezenas;
    }

    public void calcularMenorMaiorValorPago() {
        for (Sorteio sorteio : listaSorteios) {
            BigDecimal rateio4Dezenas = sorteio.getRateio_4_acertos();
            BigDecimal rateio5Dezenas = sorteio.getRateio_5_acertos();
            BigDecimal rateio6Dezenas = sorteio.getRateio_6_acertos();

            if (rateio4Dezenas.compareTo(menorValorPago4Dezenas) < 0) {
                menorValorPago4Dezenas = rateio4Dezenas;
                menorConcurso4Dezenas = sorteio.getConcurso();
            }
            if (rateio5Dezenas.compareTo(menorValorPago5Dezenas) < 0) {
                menorValorPago5Dezenas = rateio5Dezenas;
                menorConcurso5Dezenas = sorteio.getConcurso();
            }
            if (rateio6Dezenas.compareTo(menorValorPago6Dezenas) < 0) {
                menorValorPago6Dezenas = rateio6Dezenas;
                menorConcurso6Dezenas = sorteio.getConcurso();
            }
            if (rateio4Dezenas.compareTo(maiorValorPago4Dezenas) > 0) {
                maiorValorPago4Dezenas = rateio4Dezenas;
                maiorConcurso4Dezenas = sorteio.getConcurso();
            }
            if (rateio5Dezenas.compareTo(maiorValorPago5Dezenas) > 0) {
                maiorValorPago5Dezenas = rateio5Dezenas;
                maiorConcurso5Dezenas = sorteio.getConcurso();
            }
            if (rateio6Dezenas.compareTo(maiorValorPago6Dezenas) > 0) {
                maiorValorPago6Dezenas = rateio6Dezenas;
                maiorConcurso6Dezenas = sorteio.getConcurso();
            }
        }

        System.out.println("Menor valor pago para apostas com 4 dezenas sorteadas: " + menorValorPago4Dezenas
                + " (Concurso " + menorConcurso4Dezenas + ")");
        System.out.println("Maior valor pago para apostas com 4 dezenas sorteadas: " + maiorValorPago4Dezenas
                + " (Concurso " + maiorConcurso4Dezenas + ")");
        System.out.println("Menor valor pago para apostas com 5 dezenas sorteadas: " + menorValorPago5Dezenas
                + " (Concurso " + menorConcurso5Dezenas + ")");
        System.out.println("Maior valor pago para apostas com 5 dezenas sorteadas: " + maiorValorPago5Dezenas
                + " (Concurso " + maiorConcurso5Dezenas + ")");
        System.out.println("Menor valor pago para apostas com 6 dezenas sorteadas: " + menorValorPago6Dezenas
                + " (Concurso " + menorConcurso6Dezenas + ")");
        System.out.println("Maior valor pago para apostas com 6 dezenas sorteadas: " + maiorValorPago6Dezenas
                + " (Concurso " + maiorConcurso6Dezenas + ")");
    }

    public int contarGanhadores4Dezenas(List<Sorteio> listaSorteios) {
        int totalGanhadores4Dezenas = 0;

        for (Sorteio sorteio : listaSorteios) {
            totalGanhadores4Dezenas += sorteio.getGanhadores_4_acertos();
        }

        return totalGanhadores4Dezenas;
    }

    public int contarGanhadores5Dezenas(List<Sorteio> listaSorteios) {
        int totalGanhadores5Dezenas = 0;

        for (Sorteio sorteio : listaSorteios) {
            totalGanhadores5Dezenas += sorteio.getGanhadores_5_acertos();
        }

        return totalGanhadores5Dezenas;
    }

    public int contarGanhadores6Dezenas(List<Sorteio> listaSorteios) {
        int totalGanhadores6Dezenas = 0;

        for (Sorteio sorteio : listaSorteios) {
            totalGanhadores6Dezenas += sorteio.getGanhadores_6_acertos();
        }

        return totalGanhadores6Dezenas;
    }

    public void verificarSorteioDezenasInseridas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira 6 dezenas separadas por espaço (exemplo: 1 2 3 4 5 6):");

        String input = scanner.nextLine();
        String[] dezenasString = input.split(" ");

        if (dezenasString.length != 6) {
            System.out.println("Você deve inserir exatamente 6 dezenas.");
            return;
        }

        List<Integer> dezenasInseridas = new ArrayList<>();
        for (String dezenaString : dezenasString) {
            try {
                int dezena = Integer.parseInt(dezenaString);
                dezenasInseridas.add(dezena);
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido. Certifique-se de inserir apenas números.");
                return;
            }
        }

        boolean dezenasEncontradas = false;

        for (Sorteio sorteio : listaSorteios) {
            if (sorteioContemDezenas(sorteio, dezenasInseridas)) {
                System.out.println("As dezenas foram sorteadas no concurso " + sorteio.getConcurso() + " em "
                        + sorteio.getData_sorteio());
                dezenasEncontradas = true;
            }
        }

        if (!dezenasEncontradas) {
            System.out.println("As dezenas não foram sorteadas em nenhum concurso.");
        }
    }

    private boolean sorteioContemDezenas(Sorteio sorteio, List<Integer> dezenas) {
        return dezenas.contains(sorteio.getBola1()) &&
                dezenas.contains(sorteio.getBola2()) &&
                dezenas.contains(sorteio.getBola3()) &&
                dezenas.contains(sorteio.getBola4()) &&
                dezenas.contains(sorteio.getBola5()) &&
                dezenas.contains(sorteio.getBola6());
    }

    public void sortearEVerificarDezenas() {
        List<Integer> dezenasSorteadas = new ArrayList<>();
        Random random = new Random();

        System.out.print("Dezenas sorteadas: ");
        for (int i = 0; i < 6; i++) {
            int dezenaSorteada = random.nextInt(60) + 1;
            dezenasSorteadas.add(dezenaSorteada);
        }
        System.out.println(dezenasSorteadas);

        for (Sorteio sorteio : listaSorteios) {
            List<Integer> dezenasConcurso = new ArrayList<>();
            dezenasConcurso.add(sorteio.getBola1());
            dezenasConcurso.add(sorteio.getBola2());
            dezenasConcurso.add(sorteio.getBola3());
            dezenasConcurso.add(sorteio.getBola4());
            dezenasConcurso.add(sorteio.getBola5());
            dezenasConcurso.add(sorteio.getBola6());

            if (dezenasConcurso.containsAll(dezenasSorteadas)) {
                System.out.println("As dezenas sorteadas coincidem com o concurso " + sorteio.getConcurso());
                System.out.println("Data do concurso: " + sorteio.getData_sorteio());
                return;
            }
        }

        System.out.println("As dezenas sorteadas não coincidem com nenhum concurso.");
    }
}