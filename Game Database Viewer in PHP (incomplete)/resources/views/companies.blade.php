@extends('layouts.app')
@section('content')

    <div class="container">
            <div class="col-12 text-center pt-5">
                <br>
            </div>
<center>        <h2 class="display-one mt-5 font-italic font-weight-bold text-uppercase" style="margin-bottom: 60px">Companies</h2> <!-- This is the text that will be replaced by css (global.css -->
</center> <!-- center deprecié oui je sais, bref -->

            @foreach($companies as $company)
                    <a href="/companies/{{$company->COMPANY_ID}}" class="company" id="{{$company->COMPANY_ID}}">
                        <p>{{$company->COMPANY_NAME}}</p>
                    </a>
            @endforeach
    </div>
@endsection
