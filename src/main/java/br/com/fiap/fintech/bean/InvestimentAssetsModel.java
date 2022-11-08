package br.com.fiap.fintech.bean;

public class InvestimentAssetsModel {

    private int idInvestimentAssets;
    private Double vlInvestimentAssets;
    private String tpInvestimentAssets;
    private String dtInvestimentAssets;

    public InvestimentAssetsModel() {
    }

    public InvestimentAssetsModel(int idInvestimentAssets, Double vlInvestimentAssets, String tpInvestimentAssets, String dtInvestimentAssets) {
        this.setIdInvestimentAssets(idInvestimentAssets);
        this.setVlInvestimentAssets(vlInvestimentAssets);
        this.setTpInvestimentAssets(tpInvestimentAssets);
        this.setDtInvestimentAssets(dtInvestimentAssets);
    }

    public int getIdInvestimentAssets() {
        return idInvestimentAssets;
    }

    public void setIdInvestimentAssets(int idInvestimentAssets) {
        this.idInvestimentAssets = idInvestimentAssets;
    }

    public Double getVlInvestimentAssets() {
        return vlInvestimentAssets;
    }

    public void setVlInvestimentAssets(Double vlInvestimentAssets) {
        this.vlInvestimentAssets = vlInvestimentAssets;
    }

    public String getTpInvestimentAssets() {
        return tpInvestimentAssets;
    }

    public void setTpInvestimentAssets(String tpInvestimentAssets) {
        this.tpInvestimentAssets = tpInvestimentAssets;
    }

    public String getDtInvestimentAssets() {
        return dtInvestimentAssets;
    }

    public void setDtInvestimentAssets(String dtInvestimentAssets) {
        this.dtInvestimentAssets = dtInvestimentAssets;
    }
}

