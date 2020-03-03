package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void updateItem() {
        updateQuality();

        updateSellIn();

        updateQualityAfterExpiration();
    }

    private void updateQualityAfterExpiration() {
        if (isExpired()) {
            if (!isAgedBrie()) {
                if (!isBackstage()) {
                    if (quality > 0) {
                        if (!isSulfuras()) {
                            quality = quality - 1;
                        }
                    }
                } else {
                    quality = 0;
                }
            } else {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }

    private void updateSellIn() {
        if (!isSulfuras()) {
            sellIn = sellIn - 1;
        }
    }

    private void updateQuality() {
        if (!isAgedBrie()
          && !isBackstage()) {
            if (quality > 0) {
                if (!isSulfuras()) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (isBackstage()) {
                    if (sellIn < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }
            }
        }
    }

    private boolean isSulfuras() {
        return "Sulfuras, Hand of Ragnaros".equals(name);
    }

    private boolean isBackstage() {
        return "Backstage passes to a TAFKAL80ETC concert".equals(name);
    }

    private boolean isAgedBrie() {
        return "Aged Brie".equals(name);
    }
}
