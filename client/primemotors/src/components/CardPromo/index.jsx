import './card-promo-styles.css'
import byd from '../../images/NAV_BYD_SEALION_7.png'
import logo from '../../images/bydlogo.png'

export function CardPromo() {

    // const carros = [{
    //     id: 1,
    //     nome: 'byd alguma coisa',
    //     image: './images/bydlogo.png'
    // },
    //     {
    //         id: 2,
    //         nome: 'byd alguma coisa',
    //         image: './images/bydlogo.png'
    //     }
    // ]
    return (
        <div className="main-banner">
            <div className="banner-left">
                <img src={logo} alt="BYD logo" className="byd-logo" />

                <div className="banner-text">
                    <p>BYD Seal Series</p>
                    <h1>Up to 10% <br /> off Voucher</h1>
                    <a href="#">Shop Now →</a>
                </div>
            </div>

            <img src={byd} alt="banner promo" className="imagem-produto" />
        </div>
    )
}
