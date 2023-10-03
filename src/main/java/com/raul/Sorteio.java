package com.raul;

import java.math.BigDecimal;

public class Sorteio {

    private int concurso;
    private String data_sorteio;
    private int Bola1;
    private int Bola2;
    private int Bola3;
    private int Bola4;
    private int Bola5;
    private int Bola6;
    private int Ganhadores_6_acertos;
    private String UF;
    private BigDecimal Rateio_6_acertos;
    private int Ganhadores_5_acertos;
    private BigDecimal Rateio_5_acertos;
    private int Ganhadores_4_acertos;
    private BigDecimal Rateio_4_acertos;
    private BigDecimal Acumulado_6_acertos;
    private BigDecimal Arrecadacao_total;
    private BigDecimal Estimativa_premio;
    private BigDecimal Acumulado_Sorteio_Especial_Mega_da_Virada;
    private String Observacao;

    public Sorteio() {

    }

    public Sorteio(int concurso, String data_sorteio, int Bola1, int Bola2, int Bola3, int Bola4, int Bola5, int Bola6,
            int Ganhadores_6_acertos,
            String UF, BigDecimal Rateio_6_acertos, int Ganhadores_5_acertos, BigDecimal Rateio_5_acertos,
            int Ganhadores_4_acertos, BigDecimal Rateio_4_acertos,
            BigDecimal Acumulado_6_acertos, BigDecimal Arrecadacao_total, BigDecimal Estimativa_premio,
            BigDecimal Acumulado_Sorteio_Especial_Mega_da_Virada,
            String Observacao) {
        super();
        this.concurso = concurso;
        this.data_sorteio = data_sorteio;
        this.Bola1 = Bola1;
        this.Bola2 = Bola2;
        this.Bola3 = Bola3;
        this.Bola4 = Bola4;
        this.Bola5 = Bola5;
        this.Bola6 = Bola6;
        this.Ganhadores_6_acertos = Ganhadores_6_acertos;
        this.UF = UF;
        this.Rateio_6_acertos = Rateio_6_acertos;
        this.Ganhadores_5_acertos = Ganhadores_5_acertos;
        this.Rateio_5_acertos = Rateio_5_acertos;
        this.Ganhadores_4_acertos = Ganhadores_4_acertos;
        this.Rateio_4_acertos = Rateio_4_acertos;
        this.Acumulado_6_acertos = Acumulado_6_acertos;
        this.Arrecadacao_total = Arrecadacao_total;
        this.Estimativa_premio = Estimativa_premio;
        this.Acumulado_Sorteio_Especial_Mega_da_Virada = Acumulado_Sorteio_Especial_Mega_da_Virada;
        this.Observacao = Observacao;
    }

    public int getBola1() {
        return Bola1;
    }

    public int getBola2() {
        return Bola2;
    }

    public int getBola3() {
        return Bola3;
    }

    public int getBola4() {
        return Bola4;
    }

    public int getBola5() {
        return Bola5;
    }

    public int getBola6() {
        return Bola6;
    }

    public int getConcurso() {
        return concurso;
    }

    public String getData_sorteio() {
        return data_sorteio;
    }

    public int getGanhadores_4_acertos() {
        return Ganhadores_4_acertos;
    }

    public int getGanhadores_5_acertos() {
        return Ganhadores_5_acertos;
    }

    public int getGanhadores_6_acertos() {
        return Ganhadores_6_acertos;
    }

    public String getUF() {
        return UF;
    }

    public void setBola1(int bola1) {
        Bola1 = bola1;
    }

    public void setBola2(int bola2) {
        Bola2 = bola2;
    }

    public void setBola3(int bola3) {
        Bola3 = bola3;
    }

    public void setBola4(int bola4) {
        Bola4 = bola4;
    }

    public void setBola5(int bola5) {
        Bola5 = bola5;
    }

    public void setBola6(int bola6) {
        Bola6 = bola6;
    }

    public void setConcurso(int concurso) {
        this.concurso = concurso;
    }

    public void setData_sorteio(String data_sorteio) {
        this.data_sorteio = data_sorteio;
    }

    public void setGanhadores_4_acertos(int ganhadores_4_acertos) {
        Ganhadores_4_acertos = ganhadores_4_acertos;
    }

    public void setGanhadores_5_acertos(int ganhadores_5_acertos) {
        Ganhadores_5_acertos = ganhadores_5_acertos;
    }

    public void setGanhadores_6_acertos(int ganhadores_6_acertos) {
        Ganhadores_6_acertos = ganhadores_6_acertos;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }

    public void setUF(String uF) {
        UF = uF;
    }

    public BigDecimal getRateio_6_acertos() {
        return Rateio_6_acertos;
    }

    public void setRateio_6_acertos(BigDecimal rateio_6_acertos) {
        Rateio_6_acertos = rateio_6_acertos;
    }

    public BigDecimal getRateio_5_acertos() {
        return Rateio_5_acertos;
    }

    public void setRateio_5_acertos(BigDecimal rateio_5_acertos) {
        Rateio_5_acertos = rateio_5_acertos;
    }

    public BigDecimal getRateio_4_acertos() {
        return Rateio_4_acertos;
    }

    public void setRateio_4_acertos(BigDecimal rateio_4_acertos) {
        Rateio_4_acertos = rateio_4_acertos;
    }

    public BigDecimal getAcumulado_6_acertos() {
        return Acumulado_6_acertos;
    }

    public void setAcumulado_6_acertos(BigDecimal acumulado_6_acertos) {
        Acumulado_6_acertos = acumulado_6_acertos;
    }

    public BigDecimal getArrecadacao_total() {
        return Arrecadacao_total;
    }

    public void setArrecadacao_total(BigDecimal arrecadacao_total) {
        Arrecadacao_total = arrecadacao_total;
    }

    public BigDecimal getEstimativa_premio() {
        return Estimativa_premio;
    }

    public void setEstimativa_premio(BigDecimal estimativa_premio) {
        Estimativa_premio = estimativa_premio;
    }

    public BigDecimal getAcumulado_Sorteio_Especial_Mega_da_Virada() {
        return Acumulado_Sorteio_Especial_Mega_da_Virada;
    }

    public void setAcumulado_Sorteio_Especial_Mega_da_Virada(BigDecimal acumulado_Sorteio_Especial_Mega_da_Virada) {
        Acumulado_Sorteio_Especial_Mega_da_Virada = acumulado_Sorteio_Especial_Mega_da_Virada;
    }

    @Override
    public String toString() {
        return this.concurso + "\n"
                + this.data_sorteio + "\n"
                + this.Bola1 + "\n"
                + this.Bola2 + "\n"
                + this.Bola3 + "\n"
                + this.Bola4 + "\n"
                + this.Bola5 + "\n"
                + this.Bola6 + "\n"
                + this.Ganhadores_6_acertos + "\n"
                + this.UF + "\n"
                + this.Rateio_6_acertos + "\n"
                + this.Ganhadores_5_acertos + "\n"
                + this.Rateio_5_acertos + "\n"
                + this.Ganhadores_4_acertos + "\n"
                + this.Rateio_4_acertos + "\n"
                + this.Acumulado_6_acertos + "\n"
                + this.Arrecadacao_total + "\n"
                + this.Estimativa_premio + "\n"
                + this.Acumulado_Sorteio_Especial_Mega_da_Virada + "\n"
                + this.Observacao;
    }
}