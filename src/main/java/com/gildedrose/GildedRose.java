package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!"Aged Brie".equals(items[i].name)
                    && !"Backstage passes to a TAFKAL80ETC concert".equals(items[i].name)) {
                if (items[i].quality > 0) {
                    if (!"Sulfuras, Hand of Ragnaros".equals(items[i].name)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items[i].name)) {
                        if (items[i].sell_in < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(items[i].name)) {
                items[i].sell_in = items[i].sell_in - 1;
            }

            if (items[i].sell_in < 0) {
                if (!"Aged Brie".equals(items[i].name)) {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items[i].name)) {
                        if (items[i].quality > 0) {
                            if (!"Sulfuras, Hand of Ragnaros".equals(items[i].name)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
