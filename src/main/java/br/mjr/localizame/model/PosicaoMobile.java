package br.mjr.localizame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PosicaoMobile implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double latitude;
	private Double longitude;

	public PosicaoMobile() { }

	public PosicaoMobile(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PosicaoMobile that = (PosicaoMobile) o;

		if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
		return longitude != null ? longitude.equals(that.longitude) : that.longitude == null;

	}

	@Override
	public int hashCode() {
		int result = latitude != null ? latitude.hashCode() : 0;
		result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "PosicaoMobile{" +
				"latitude=" + latitude +
				", longitude=" + longitude +
				'}';
	}
}

