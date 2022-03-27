public class ListingPage {
    private static ListingPage listingPage;

    public ProductCard getProductCard(String productName) {
        return ProductCard.getProductCard(productName);
    }
    public BlockFilter getBlockFilter(String title, String filterName){
        return BlockFilter.getBlockFilter(title,filterName);
    }
}


