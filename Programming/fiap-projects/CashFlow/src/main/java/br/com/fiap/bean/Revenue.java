package br.com.fiap.bean;

public class Revenue {
	
	private int idRevenue;
	private Double vlRevenue;

	public Revenue() {
	}
	
	public Revenue(int idRevenue, Double vlRevenue) {
		this.setIdRevenue(idRevenue);
		this.setVlRevenue(vlRevenue);
	}

	public int getIdRevenue() {
		return idRevenue;
	}

	public void setIdRevenue(int idRevenue) {
		this.idRevenue = idRevenue;
	}

	public Double getVlRevenue() {
		return vlRevenue;
	}

	public void setVlRevenue(Double vlRevenue) {
		this.vlRevenue = vlRevenue;
	}
	
}
