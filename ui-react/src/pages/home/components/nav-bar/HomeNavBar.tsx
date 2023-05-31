import React from 'react';
import logo from '../../../../assets/logo.svg';
import signOut from '../../../../assets/sign-out.svg';
import {Link, useNavigate} from 'react-router-dom';
import './HomeNavBarStyle.scss';
import axios, {AxiosRequestConfig} from "axios/index";

type UserType = {
    email: string;
    firstName: string;
    lastName: string;
    pictureUrl: string;
    role: string;
}

const HomeNavBar: React.FunctionComponent = () => {
    const navigate = useNavigate();
    const logout = () => {
        localStorage.removeItem('token');
        navigate('/login');
    };

    const [user, setUser] = React.useState<UserType>();

    const getUserData = async (): Promise<void> => {
        const token: string = localStorage.getItem('token');
        const config: AxiosRequestConfig = {
            headers: {
                Authorization: `Bearer ${token}`,
            },
        };

        if (!token) {
            return navigate('/login');
        }

        await axios.get('http://localhost:8080/api/users/me', config)
            .then(res => setUser(res.data))
            .catch(err => err.response.status != 200 ? navigate('/login') : null);
    };

    React.useEffect(() => {
        getUserData();
    }, []);

    return (
        <nav className='home-page-nav-bar'>
            <ul>
                <li>
                    <img src={logo} alt='FoodBook' className='nav-bar-logo'/>
                </li>
                <li>
                    <Link to='/find-recipes' className='nav-bar-link'>Find recipes</Link>
                </li>
                <li>
                    <Link to='/create-recipe' className='nav-bar-link'>Create recipe</Link>
                </li>
                <li className='nav-bar-logout'>
                    <img src={signOut} alt='logout' onClick={logout}/>
                </li>
            </ul>
        </nav>
    );
};

export default HomeNavBar;