package com.raul;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Scanner;

public class Inicializador {

    public static void main(String[] args) {
        Acaomeu acaomeu = new Acaomeu();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser
                .setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Arquivos Excel (*.xlsx)", "xlsx"));

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String caminhoArquivo = fileChooser.getSelectedFile().getPath();

            try {
                File arquivo = new File(caminhoArquivo);
                BufferedInputStream buf = new BufferedInputStream(new FileInputStream(arquivo));

                acaomeu.lerArqXlsxSorteio(buf);

                JOptionPane.showMessageDialog(null, "Leitura do arquivo concluída com sucesso.");

                apresentarMenu(acaomeu);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo Excel.\nDetalhes: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado.");
        }
    }

    public static void apresentarMenu(Acaomeu acaomeu) {
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Contagem de números sorteados");
            System.out.println("2. Contagem de concursos sem ganhadores das 6 dezenas");
            System.out.println("3. Calcular menor e maior valor pago para acertos de 4, 5 e 6 dezenas");
            System.out.println("4. Contagem de ganhadores para acertos de 4, 5 e 6 dezenas");
            System.out.println("5. Verificar dezenas inseridas");
            System.out.println("6. Sortear e verificar dezenas");
            System.out.println("0. Sair");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Map<Integer, Integer> contagemNumeros = acaomeu.contarNumerosSorteados();
                    for (Map.Entry<Integer, Integer> entry : contagemNumeros.entrySet()) {
                        System.out.println("Número " + entry.getKey() + " foi sorteado " +
                                entry.getValue() + " vezes.");
                    }
                    break;
                case 2:
                    int concursosSemGanhadores6Dezenas = acaomeu
                            .contarConcursosSemGanhadores6Dezenas(acaomeu.getListaSorteios());
                    System.out.println("Quantidade de concursos sem ganhadores de 6 dezenas: " +
                            concursosSemGanhadores6Dezenas);
                    break;
                case 3:
                    acaomeu.calcularMenorMaiorValorPago();
                    break;
                case 4:
                    int totalGanhadores4Dezenas = acaomeu.contarGanhadores4Dezenas(acaomeu.getListaSorteios());
                    int totalGanhadores5Dezenas = acaomeu.contarGanhadores5Dezenas(acaomeu.getListaSorteios());
                    int totalGanhadores6Dezenas = acaomeu.contarGanhadores6Dezenas(acaomeu.getListaSorteios());
                    System.out.println(
                            "Quantidade de ganhadores com 4 dezenas em todos os concursos realizados: "
                                    + totalGanhadores4Dezenas);
                    System.out.println(
                            "Quantidade de ganhadores com 5 dezenas em todos os concursos realizados: "
                                    + totalGanhadores5Dezenas);
                    System.out.println(
                            "Quantidade de ganhadores com 6 dezenas em todos os concursos realizados: "
                                    + totalGanhadores6Dezenas);
                    break;
                case 5:
                    acaomeu.verificarSorteioDezenasInseridas();
                    break;
                case 6:
                    acaomeu.sortearEVerificarDezenas();
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
}