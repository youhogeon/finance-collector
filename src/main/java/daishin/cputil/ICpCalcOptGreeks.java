package daishin.cputil  ;

import com4j.*;

/**
 * ICpCalcOptGreeks �������̽�
 */
@IID("{AE72A9FD-E459-4678-B8CA-7417BEF26142}")
public interface ICpCalcOptGreeks extends Com4jObject {
  // Methods:
  /**
   * <p>
   * property ��ǲ����
   * </p>
   * <p>
   * Setter method for the COM property "CallPutType"
   * </p>
   * @param rhs Mandatory daishin.cputil.CALLPUT_TYPE parameter.
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(7)
  void callPutType(
    daishin.cputil.CALLPUT_TYPE rhs);


  /**
   * <p>
   * property �ɼǰ���
   * </p>
   * <p>
   * Setter method for the COM property "Price"
   * </p>
   * @param rhs Mandatory double parameter.
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(8)
  void price(
    double rhs);


  /**
   * <p>
   * property �����ڻ갡��
   * </p>
   * <p>
   * Setter method for the COM property "UnderPrice"
   * </p>
   * @param rhs Mandatory double parameter.
   */

  @DISPID(3) //= 0x3. The runtime will prefer the VTID if present
  @VTID(9)
  void underPrice(
    double rhs);


  /**
   * <p>
   * property ��簡��
   * </p>
   * <p>
   * Setter method for the COM property "ExerPrice"
   * </p>
   * @param rhs Mandatory double parameter.
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(10)
  void exerPrice(
    double rhs);


  /**
   * <p>
   * property ������Ÿ��
   * </p>
   * <p>
   * Setter method for the COM property "VolatilityType"
   * </p>
   * @param rhs Mandatory daishin.cputil.VOLATILITY_TYPE parameter.
   */

  @DISPID(5) //= 0x5. The runtime will prefer the VTID if present
  @VTID(11)
  void volatilityType(
    daishin.cputil.VOLATILITY_TYPE rhs);


  /**
   * <p>
   * property ������
   * </p>
   * <p>
   * Setter method for the COM property "Volatility"
   * </p>
   * @param rhs Mandatory double parameter.
   */

  @DISPID(6) //= 0x6. The runtime will prefer the VTID if present
  @VTID(12)
  void volatility(
    double rhs);


  /**
   * <p>
   * property �����ϼ�
   * </p>
   * <p>
   * Setter method for the COM property "ExpirDays"
   * </p>
   * @param rhs Mandatory int parameter.
   */

  @DISPID(7) //= 0x7. The runtime will prefer the VTID if present
  @VTID(13)
  void expirDays(
    int rhs);


  /**
   * <p>
   * property ������������
   * </p>
   * <p>
   * Setter method for the COM property "RFInterRate"
   * </p>
   * @param rhs Mandatory double parameter.
   */

  @DISPID(8) //= 0x8. The runtime will prefer the VTID if present
  @VTID(14)
  void rfInterRate(
    double rhs);


  /**
   * <p>
   * property �����������簡ġ
   * </p>
   * <p>
   * Setter method for the COM property "DividRate"
   * </p>
   * @param rhs Mandatory double parameter.
   */

  @DISPID(9) //= 0x9. The runtime will prefer the VTID if present
  @VTID(15)
  void dividRate(
    double rhs);


  /**
   * <p>
   * method ���
   * </p>
   */

  @DISPID(10) //= 0xa. The runtime will prefer the VTID if present
  @VTID(16)
  void calculate();


  /**
   * <p>
   * property �̷а���
   * </p>
   * <p>
   * Getter method for the COM property "TV"
   * </p>
   * @return  Returns a value of type double
   */

  @DISPID(11) //= 0xb. The runtime will prefer the VTID if present
  @VTID(17)
  double tv();


  /**
   * <p>
   * property ��Ÿ
   * </p>
   * <p>
   * Getter method for the COM property "Delta"
   * </p>
   * @return  Returns a value of type double
   */

  @DISPID(12) //= 0xc. The runtime will prefer the VTID if present
  @VTID(18)
  double delta();


  /**
   * <p>
   * property ����
   * </p>
   * <p>
   * Getter method for the COM property "Gamma"
   * </p>
   * @return  Returns a value of type double
   */

  @DISPID(13) //= 0xd. The runtime will prefer the VTID if present
  @VTID(19)
  double gamma();


  /**
   * <p>
   * property ��Ÿ
   * </p>
   * <p>
   * Getter method for the COM property "Theta"
   * </p>
   * @return  Returns a value of type double
   */

  @DISPID(14) //= 0xe. The runtime will prefer the VTID if present
  @VTID(20)
  double theta();


  /**
   * <p>
   * property ����
   * </p>
   * <p>
   * Getter method for the COM property "Vega"
   * </p>
   * @return  Returns a value of type double
   */

  @DISPID(15) //= 0xf. The runtime will prefer the VTID if present
  @VTID(21)
  double vega();


  /**
   * <p>
   * property ��
   * </p>
   * <p>
   * Getter method for the COM property "Rho"
   * </p>
   * @return  Returns a value of type double
   */

  @DISPID(16) //= 0x10. The runtime will prefer the VTID if present
  @VTID(22)
  double rho();


  /**
   * <p>
   * property ���纯����
   * </p>
   * <p>
   * Getter method for the COM property "IV"
   * </p>
   * @return  Returns a value of type double
   */

  @DISPID(17) //= 0x11. The runtime will prefer the VTID if present
  @VTID(23)
  double iv();


  // Properties:
}
