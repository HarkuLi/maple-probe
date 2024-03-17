export class AssetUrl
{
  monster(id) {
    return new URL(`../assets/monsters/${id}.png`, import.meta.url).href
  }

  monsterDefault() {
    return new URL('../assets/monsters/default.png', import.meta.url).href
  }
}
