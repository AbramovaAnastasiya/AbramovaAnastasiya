public interface XpathContainers {

    public final String XPATH_FILTER_CONTAINER = "//div[contains(@class, 'filter-container--modal-filters')]";
    //public final String XPATH_FILTER_CHECKBOX_LIST = "form[@class = 'filter-checkbox-list']";
    public final String XPATH_TITLE_CHECKBOX_LIST = "//span[contains(@class, 'accordion__title-text')][text() = ' %s ']";
    // public final String XPATH_FILTER_NAME = "//div[@class = 'checkbox']//span/a[text() = ' %s ']" ;
    public final String NEXT_PAGE = "//div//li[@class='page-item']/a[contains(@class, 'ng-star-inserted')]";
    public final String XPATH_CONTAINER_PRODUCT_CARD = "//div[@class='plp__card-grid']";

}
