import React from 'react';
import GoogleLogo from '../../../../../assets/google-logo.svg';
import {useNavigate} from 'react-router-dom';
import './GoogleLoginStyle.scss';
import {useGoogleLogin} from '@react-oauth/google';
import axios from 'axios';

type GoogleResponse = {
    code: string;
    authuser: string;
    prompt: string;
    scope: string;
}

const GoogleLogin: React.FunctionComponent = () => {
    const navigate = useNavigate();

    const loginWithGoogle = useGoogleLogin({
        onSuccess: async (response: GoogleResponse) => {
            const code = response.code;
            await axios
                .post('http://localhost:8080/api/security/oauth/google', {code})
                .then(resp => localStorage.setItem('token', resp.data));
            navigate('/find-recipes');
        },
        flow: 'auth-code'
    });

    return (
        <div className='google-login-container'>
            <button className='google-login-button' onClick={loginWithGoogle}>
                <img src={GoogleLogo} alt='Google login'/>
            </button>
        </div>
    );
};

export default GoogleLogin;