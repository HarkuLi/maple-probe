import { AppConfig } from "@/config/app";

export class Maprobe {
  constructor() {
    this.host = AppConfig.SERVER_HOST;
  }

  async getAccessories() {
    const response = await fetch(`${this.host}/items/accessories`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getCapes() {
    const response = await fetch(`${this.host}/items/capes`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getCaps() {
    const response = await fetch(`${this.host}/items/caps`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getCoats() {
    const response = await fetch(`${this.host}/items/coats`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getEtc() {
    const response = await fetch(`${this.host}/items/etc`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getFaces() {
    const response = await fetch(`${this.host}/items/faces`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getGloves() {
    const response = await fetch(`${this.host}/items/gloves`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getLongCoats() {
    const response = await fetch(`${this.host}/items/longcoats`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getPants() {
    const response = await fetch(`${this.host}/items/pants`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getRings() {
    const response = await fetch(`${this.host}/items/rings`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getShields() {
    const response = await fetch(`${this.host}/items/shields`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getShoes() {
    const response = await fetch(`${this.host}/items/shoes`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getUses() {
    const response = await fetch(`${this.host}/items/uses`);
    const body = await response.json();
    return body ? body.data : []
  }

  async getWeapons() {
    const response = await fetch(`${this.host}/items/weapons`);
    const body = await response.json();
    return body ? body.data : []
  }
}
