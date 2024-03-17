export class PublicUrl
{
  monster(id) {
    return `/monsters/${id}.png`
  }

  monsterDefault() {
    return '/monsters/default.png'
  }

  item(id) {
    return `/items/${id}.png`
  }

  itemDefault() {
    return '/monsters/default.png'
  }
}
