package models;

public class Player {
  
    private String _pseudo;
    private String _shape;
    private String _color;
    private int _playCount;
    public Boolean _isWinner = false;

    public String getPseudo() {
        return _pseudo;
    }
    public void setPseudo(String _pseudo) {
        this._pseudo = _pseudo;
    }
    public String getShape() {
        return _shape;
    }
    public void setShape(String _shape) {
        this._shape = _shape;
    }
    public String getColor() {
        return _color;
    }
    public void setColor(String _color) {
        this._color = _color;
    }
    public int getPlayCount() {
        return _playCount;
    }
    public void setPlayCount(int _playCount) {
        this._playCount = _playCount;
    }
    public Boolean getIsWinner() {
        return _isWinner;
    }
    public void setIsWinner(Boolean _isWinner) {
        this._isWinner = _isWinner;
    }
}
