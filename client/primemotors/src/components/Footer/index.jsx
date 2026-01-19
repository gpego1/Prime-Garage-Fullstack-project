import './footer-style.css'
import { IoMdSend } from "react-icons/io";

export function Footer() {
    return (
        <footer className="footer">
            <div className="footer-container">
                <div className="footer-col">
                    <h3>Exclusive</h3>
                    <h4>Subscribe</h4>
                    <p>Get 10% off your first order</p>
                    <div className="subscribe-box">
                        <input type="email" placeholder="Enter your email"/>
                        <button type="submit"><IoMdSend /></button>

                    </div>
                </div>
                <div className="footer-col">
                    <h3>Support</h3>
                    <p>111 Bijoy sarani, Dhaka, DH 1515, Bangladesh.</p>
                    <p>exclusive@gmail.com</p>
                    <p>+88015-88888-9999</p>
                </div>
                <div className="footer-col">
                    <h3>Account</h3>
                    <ul>
                        <li><a href="#">My Account</a></li>
                        <li><a href="#">Login / Register</a></li>
                        <li><a href="#">Cart</a></li>
                        <li><a href="#">Wishlist</a></li>
                        <li><a href="#">Shop</a></li>
                    </ul>
                </div>

                <div className="footer-col">
                    <h3>Quick Link</h3>
                    <ul>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms Of Use</a></li>
                        <li><a href="#">FAQ</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </div>

            </div>
        </footer>
    )
}