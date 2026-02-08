import './cardItems-styles.css';
import dolphinImg from "../../images/cards/dolphin2.png";
import sealImg from "../../images/cards/seal.png";
import tanImg from "../../images/cards/tan.webp";
import dolphinBlueImg from "../../images/cards/dolphin.webp";
import mercedesImg from "../../images/cards/mercedes.png";
import { FaShoppingCart } from "react-icons/fa";

export function CardItems() {
    const items = [
        {
            id: 1,
            name: 'Byd dolphin',
            image: dolphinImg,
        },
        {
            id: 2,
            name: 'BYD Seal',
            image: sealImg,
        },
        {
            id: 3,
            name: 'BYD Tan',
            image: tanImg,
        },
        {
            id: 5,
            name: 'BYD Dolphin Blue',
            image: dolphinBlueImg,
        },
        {
            id: 6,
            name: 'Mercedes',
            image: mercedesImg,
        }
    ]

    return (
        <div className="cardItems">
            <section>
                {items.map((item) => (
                    <div className="product-card" key={item.id}>
                        <img className="card-img" src={item.image} alt={item.name} />
                        <p className="product-names">{item.name}</p>

                        <button className="add-cart-btn">
                            <FaShoppingCart />
                            Add to Cart
                        </button>
                    </div>
                ))}
            </section>
        </div>
    )
}