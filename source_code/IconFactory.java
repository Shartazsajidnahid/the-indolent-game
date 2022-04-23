public class IconFactory {

    public Icons getIcons(int type){
        if(type ==1) return  new yellowIcon();
        else if (type == 3) return  new yellowIcon();

        return new whiteIcon();
    }

}
