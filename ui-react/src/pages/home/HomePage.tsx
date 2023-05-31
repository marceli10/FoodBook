import React from 'react';
import axios, {AxiosRequestConfig} from 'axios';
import HomeNavBar from './components/nav-bar/HomeNavBar';
import {useNavigate} from 'react-router-dom';


type UserType = {
    email: string;
    firstName: string;
    lastName: string;
    pictureUrl: string;
    role: string;
}

const HomePage: React.FunctionComponent = () => {
    const navigate = useNavigate();
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
        <div>
            <HomeNavBar />
        </div>
    );
};

export default HomePage;