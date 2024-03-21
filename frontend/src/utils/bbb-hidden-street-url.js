import { AppConfig } from "@/config/app";

export class BbbHidenStreetUrl
{
  constructor() {
    this.baseUrl = AppConfig.BBB_HIDDEN_STREET_URL;
  }

  monster(name) {
    

    return `${this.baseUrl}/monster/${this.#toUrlCompatible(name)}`
  }

  /**
   * @param string str
   * @returns {string}
   */
  #toUrlCompatible(str) {
    return str.toLowerCase()
      .replace(/\./g, '')
      .split(' ')
      .join('-')
  }

  search(keyword) {
    return `${this.baseUrl}/search_finder/${keyword}`
  }
}
